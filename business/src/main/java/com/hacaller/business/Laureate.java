package com.hacaller.business;

import java.util.Comparator;

/**
 * Created by Herbert Caller on 09/11/2018.
 */
public class Laureate {

    private Integer id;
    private Integer year;
    private String country;
    private String name;
    private String flag;
    private String photo;
    private String category;

    public Laureate(Integer id, Integer year, String country, String flag, String photo, String category, String name) {
        this.id = id;
        this.year = year;
        this.country = country;
        this.flag = flag;
        this.photo = photo;
        this.category = category;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
