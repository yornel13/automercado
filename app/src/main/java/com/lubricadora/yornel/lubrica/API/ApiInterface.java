package com.lubricadora.yornel.lubrica.API;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Yornel on 23-sep-16.
 */
public interface ApiInterface {

    @GET("clientes/{cedula}")
    Call<JsonObject> login(@Path("cedula") String cedula);
}
