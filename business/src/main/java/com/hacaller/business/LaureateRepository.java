package com.hacaller.business;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herbert Caller on 10/11/2018.
 */
public class LaureateRepository {

    List<Laureate> cached;
    LaureateService service;

    public LaureateRepository(LaureateService service) {
        cached =  new ArrayList<>();
        this.service = service;
    }

    public List<Laureate> fetchLaureates() {

        if ( cached.isEmpty()) {
            cached = service.fetchLaureates();
        }
        return cached;
    }


}
