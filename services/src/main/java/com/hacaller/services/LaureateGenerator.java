package com.hacaller.services;

import com.hacaller.business.Laureate;

/**
 * Created by Herbert Caller on 09/11/2018.
 */
public class LaureateGenerator {

    private LaureateGenerator(){}

    public static Laureate toLaureate(LaureateResponse o){
        return new Laureate(
                o.getId(),
                o.getYear(),
                o.getCountry(),
                o.getFlag(),
                o.getPhoto(),
                o.getCategory(),
                o.getName()
        );
    }

}
