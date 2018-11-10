package com.hacaller.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Herbert Caller on 09/11/2018.
 */
public class LaureateCasePicker {

    public LaureateCasePicker(){}

    List<Laureate> laureates;
    LaureateCaseConsumer consumer;
    LaureateRepository repo;
    LaureateQuery q;
    boolean isChained;

    public LaureateCasePicker(LaureateService laureateService) {
        repo = new LaureateRepository(laureateService);
    }

    public void setChained(boolean chained) {
        isChained = chained;
    }

    public void setLaureates(List<Laureate> laureates) {
        this.laureates = laureates;
    }

    public LaureateCaseConsumer getConsumer() {
        return consumer;
    }

    public LaureateCase getLaureateCase() {
        return q.laureateCase;
    }

    public void setLaureateCase(LaureateQuery q) {
        this.q = q;
    }

    public void setConsumer(LaureateCaseConsumer consumer) {
        this.consumer = consumer;
    }

    public void apply() throws LaureateException {
        if (q.laureateCase == null) throw new LaureateException();
        switch (q.laureateCase){
            case GetAllLaureates:
                getAllLaureates();
                break;
            case GetLaureatesByCountry:
                if (q == null) throw new LaureateException();
                getLaureatesByCountry(q.getCountry());
                break;
            case GetLaureatesByCategory:
                if (q == null) throw new LaureateException();
                getLaureatesByCategory(q.getCategory());
                break;
        }
    }

    void callConsumer(Object o){
        //if ( o instanceof Laureate ) System.out.println(((Laureate) o).getName());
        if (consumer!= null) consumer.processLaureateCaseResult(o);
    }

    void getAllLaureates(){
        showCurrentThread("full list");
        long start = System.currentTimeMillis();
        List<Laureate> o = repo.fetchLaureates();
        callConsumer(o);
        showProcessingTime(start);
    }

    // Emit an item instead sending all items
    void getLaureatesByCountry(String country){
        showCurrentThread(country);
        long start = System.currentTimeMillis();
        List<Laureate> o = shortListedLaureates();
        if (isChained){
            List<Laureate> p = new ArrayList<>();
            for (Laureate l: o){
                if (l.getCountry().toLowerCase().contains(country.toLowerCase())) p.add(l);
            }
            callConsumer(p);
        } else {
            for (Laureate l: o){
                setDelay(50);
                if (l.getCountry().toLowerCase().contains(country.toLowerCase())) callConsumer(l);
            }
        }
        showProcessingTime(start);
    }

    // Emit an item instead sending all items
    void getLaureatesByCategory(String category){
        showCurrentThread(category);
        long start = System.currentTimeMillis();
        List<Laureate> o = shortListedLaureates();
        if (isChained){
            List<Laureate> p = new ArrayList<>();
            for (Laureate l: o){
                if (l.getCategory().toLowerCase().contains(category.toLowerCase())) p.add(l);
            }
            callConsumer(p);
        } else {
            for (Laureate l: o){
                setDelay(20);
                if (l.getCategory().toLowerCase().contains(category.toLowerCase())) callConsumer(l);
            }
        }
        showProcessingTime(start);
    }

    void setDelay(long delayInMillis){
        long start = System.currentTimeMillis();
        long elapsed = System.currentTimeMillis() - start;
        while (elapsed < delayInMillis) {
            elapsed = System.currentTimeMillis() - start;
        }
    }

    void showProcessingTime(long start){

        long elapsed = System.currentTimeMillis() - start;
        System.out.println("LaureateCaseWorker completed in: " + elapsed + " ms");
    }

    void showCurrentThread(String message){
        System.out.println("LaureateCaseWorker with query: " + message);
        System.out.println("LaureateCaseWorker on Thread: " + Thread.currentThread());
    }

    List<Laureate> shortListedLaureates(){
        if (laureates == null){
            return repo.fetchLaureates();
        } else {
            return laureates;
        }
    }


}
