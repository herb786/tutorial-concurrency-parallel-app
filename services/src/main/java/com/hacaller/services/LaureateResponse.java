package com.hacaller.services;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Herbert Caller on 09/11/2018.
 */
public class LaureateResponse {

    @SerializedName("id")
    private Integer id;

    @SerializedName("year")
    private Integer year;

    @SerializedName("country")
    private String country;

    @SerializedName("rationale")
    private String rationale;

    @SerializedName("flag")
    private String flag;

    @SerializedName("photo")
    private String photo;

    @SerializedName("category")
    private String category;

    @SerializedName("genre")
    private String genre;

    @SerializedName("name")
    private String name;

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

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
