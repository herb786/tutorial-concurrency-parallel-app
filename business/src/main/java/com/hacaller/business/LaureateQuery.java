package com.hacaller.business;

/**
 * Created by Herbert Caller on 10/11/2018.
 */
public class LaureateQuery {

    LaureateCase laureateCase;
    String category;
    String country;

    public LaureateQuery(LaureateCase laureateCase, String category, String country) {
        this.laureateCase = laureateCase;
        this.category = category;
        this.country = country;
    }

    public LaureateCase getLaureateCase() {
        return laureateCase;
    }

    public String getCategory() {
        return category;
    }

    public String getCountry() {
        return country;
    }
}
