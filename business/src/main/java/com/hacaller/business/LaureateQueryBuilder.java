package com.hacaller.business;

/**
 * Created by Herbert Caller on 10/11/2018.
 */
public class LaureateQueryBuilder {

    LaureateCase laureateCase;
    String category;
    String country;

    public LaureateQueryBuilder(){}

    public LaureateQuery build(){
        return new LaureateQuery(laureateCase, category, country);

    }

    public LaureateQueryBuilder setUseCase(LaureateCase laureateCase){
        this.laureateCase = laureateCase;
        return this;
    }

    public LaureateQueryBuilder setParams(String country, String category){
        this.category = category;
        this.country = country;
        return this;
    }

    public LaureateQueryBuilder setCategory(String category){
        this.category = category;
        return this;
    }

    public LaureateQueryBuilder setCountry(String country){
        this.country = country;
        return this;
    }

}
