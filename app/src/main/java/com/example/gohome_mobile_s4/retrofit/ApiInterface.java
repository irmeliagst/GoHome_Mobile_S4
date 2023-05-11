package com.example.gohome_mobile_s4.retrofit;

import com.example.gohome_mobile_s4.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("fooddata.json")
    Call<List<RoomData>> getAllData();


    // lets make our model class of json data.

}
