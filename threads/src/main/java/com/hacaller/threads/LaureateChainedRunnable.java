package com.hacaller.threads;

import com.hacaller.business.Laureate;
import com.hacaller.business.LaureateCaseConsumer;
import com.hacaller.business.LaureateCasePicker;
import com.hacaller.business.LaureateException;
import com.hacaller.business.LaureateService;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Herbert Caller on 10/11/2018.
 */
public class LaureateChainedRunnable extends LaureateRunnableFactory
        implements LaureateCaseConsumer {

    LaureateJob[] jobs;
    LaureateService service;

    public LaureateChainedRunnable(LaureateService service, LaureateJob[] jobs) {
        this.jobs = jobs;
        this.service = service;
    }

    @Override
    public void run() {
        LaureateJob job = jobs[0];
        LaureateCasePicker casePicker =  new LaureateCasePicker(service);
        casePicker.setLaureateCase(job.query);
        casePicker.setChained(true);
        casePicker.setConsumer(this);
        try {
            casePicker.apply();
        } catch (LaureateException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void processLaureateCaseResult(Object o) {
        LaureateJob job = jobs[1];
        LaureateCasePicker casePicker =  new LaureateCasePicker(service);
        casePicker.setLaureateCase(job.query);
        casePicker.setLaureates((List<Laureate>) o);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new LaureateSimpleRunnable(casePicker, job.listener));
    }

}
