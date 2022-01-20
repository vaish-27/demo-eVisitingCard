package com.example.helloapp;

import android.renderscript.Sampler;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
 @GET("/users")
  Call<List<InformationModelClass>> getUsers();


}
