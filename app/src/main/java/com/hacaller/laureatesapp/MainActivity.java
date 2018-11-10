package com.hacaller.laureatesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.hacaller.business.Laureate;
import com.hacaller.business.LaureateCase;
import com.hacaller.business.LaureateQuery;
import com.hacaller.business.LaureateQueryBuilder;
import com.hacaller.services.LaureateServiceImpl;
import com.hacaller.threads.LaureateCaseListener;
import com.hacaller.threads.LaureateCaseManager;
import com.hacaller.threads.LaureateJob;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recFullList;
    RecyclerView recByCountry;
    RecyclerView recByCategory;

    LaureateAdapter adapterFull;
    LaureateAdapter adapterCountry;
    LaureateAdapter adapterCategory;

    LaureateCaseListener caseChained;
    LaureateCaseListener caseCountry;
    LaureateCaseListener caseCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        adapterFull = new LaureateAdapter();
        recFullList = findViewById(R.id.recFullList);
        recFullList.setAdapter(adapterFull);

        adapterCountry =  new LaureateAdapter();
        recByCountry = findViewById(R.id.recByCountry);
        recByCountry.setAdapter(adapterCountry);

        adapterCategory =  new LaureateAdapter();
        recByCategory = findViewById(R.id.recByCategory);
        recByCategory.setAdapter(adapterCategory);

        LaureateQuery q1 = (new LaureateQueryBuilder())
                .setUseCase(LaureateCase.GetLaureatesByCountry)
                .setCountry("Japan")
                .build();

        LaureateQuery q2 = (new LaureateQueryBuilder())
                .setUseCase(LaureateCase.GetLaureatesByCategory)
                .setCategory("Physics")
                .build();

        caseChained = new LaureateCaseListener() {
            @Override
            public void onTaskCompleted(Object o) {
                adapterFull.addLaureate((Laureate) o);
            }
        };

        caseCountry = new LaureateCaseListener() {
            @Override
            public void onTaskCompleted(Object o) {
                adapterCountry.addLaureate((Laureate) o);
            }
        };

        caseCategory = new LaureateCaseListener() {
            @Override
            public void onTaskCompleted(Object o) {
                adapterCategory.addLaureate((Laureate) o);
            }
        };

        LaureateCaseManager caseManager = new LaureateCaseManager(new LaureateServiceImpl());
        caseManager.addChainedCase(new LaureateJob(q1, null), new LaureateJob(q2, caseChained) );
        caseManager.addJob(new LaureateJob(q1, caseCountry));
        caseManager.addJob(new LaureateJob(q2, caseCategory));
        caseManager.execute();


    }
}
