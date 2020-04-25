package com.example.hospitalapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DataServices {

    @POST("/login")
    Call<UserDetails> executeLogin(@Body LoginResult loginResult);

    @POST("/user/register")
    Call<UserDetails> executeSignUp(@Body LoginResult loginResult);

    @POST("/user/edit")
    Call<String> executeEditUserProfile(@Body UserDetails user);

    @GET("/user/edit/{userID}")
    Call<UserDetails> executeGetUserProfileByID(@Path(value = "userID", encoded = true) int userID);



}
