package com.example.hefen.threerecyclerview.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hefen on 2/26/2018.
 */

public class RetrofitInstance {
    ////http://api.duckduckgo.com/?q=simpsons+characters&format=json
    public static final String BASE_URL = "http://api.duckduckgo.com/";

    static Retrofit retrofit = null;

    public static Retrofit getRetrofitInstance() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
