package com.hacaller.services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Herbert Caller on 09/11/2018.
 */
public interface LaureateAPI {

    @GET("/api/laureates")
    Call<List<LaureateResponse>> getLaureates();

}
