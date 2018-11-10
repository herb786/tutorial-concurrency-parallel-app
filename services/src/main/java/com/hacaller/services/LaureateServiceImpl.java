package com.hacaller.services;

import com.hacaller.business.Laureate;
import com.hacaller.business.LaureateService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Herbert Caller on 09/11/2018.
 */
public class LaureateServiceImpl implements LaureateService {

    @Override
    public synchronized List<Laureate> fetchLaureates() {
        List<Laureate> laureates = new ArrayList<>();
        try {
            List<LaureateResponse> list = getLaureateAPI()
                    .getLaureates()
                    .execute()
                    .body();
            for (LaureateResponse o: list){
                laureates.add(LaureateGenerator.toLaureate(o));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return laureates;
    }


    Retrofit getCustomRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://hacagusae.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    LaureateAPI getLaureateAPI(){
        return getCustomRetrofit().create(LaureateAPI.class);
    }

}
