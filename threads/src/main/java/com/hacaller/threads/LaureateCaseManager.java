package com.hacaller.threads;


import com.hacaller.business.Laureate;
import com.hacaller.business.LaureateCase;
import com.hacaller.business.LaureateCasePicker;
import com.hacaller.business.LaureateQuery;
import com.hacaller.business.LaureateService;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Herbert Caller on 09/11/2018.
 */
public class LaureateCaseManager  {

    ThreadPoolExecutor service;

    LinkedBlockingQueue messageQueue = new LinkedBlockingQueue<LaureateSimpleRunnable>();

    LaureateService laureateService;


    public LaureateCaseManager(LaureateService laureateService) {
        this.laureateService = laureateService;
    }

    public void execute(){
        int processors = Runtime.getRuntime().availableProcessors();
        service = new ThreadPoolExecutor(
                processors,
                processors,
                5000,
                TimeUnit.MILLISECONDS,
                messageQueue);
        service.prestartAllCoreThreads();
    }


    public LaureateCaseManager addJob(LaureateJob job){
        LaureateCasePicker casePicker =  new LaureateCasePicker(laureateService);
        casePicker.setLaureateCase(job.query);
        messageQueue.add(new LaureateSimpleRunnable(casePicker, job.listener));
        return this;
    }


    public LaureateCaseManager addChainedCase(LaureateJob... jobs){
        messageQueue.add(new LaureateChainedRunnable(laureateService, jobs));
        return this;
    }

    public void cancelJobs(){
        service.shutdownNow();
    }



}
