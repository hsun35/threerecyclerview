package com.example.hefen.threerecyclerview.network;

import com.example.hefen.threerecyclerview.model.SimpsonsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//import static com.android.volley.Request.Method.GET;!!volley

/**
 * Created by hefen on 2/26/2018.
 */

public interface SimpsonsService {
    //http://api.duckduckgo.com/?q=simpsons+characters&format=json
    @GET(".")
    Call<SimpsonsResponse> getSimpsonsDetails(@Query(value = "q", encoded = true) String s1, @Query("format") String s2);//need correct
    //Call<SimpsonsResponse> getSimpsonsDetails(@Query("q") String characters,
    //                                       @Query("format") String json);//CategoryResponse
}
