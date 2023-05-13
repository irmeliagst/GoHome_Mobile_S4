package com.example.gohome_mobile_s4.retrofit;

import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.Model.MenungguModel;
import com.example.gohome_mobile_s4.Model.login.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    String BASE_URL = "http://192.168.1.58:8000/api/";

    @FormUrlEncoded
    @POST("login")
    Call<Data>login(
            @Field("email") String email,
            @Field("password") String password);
    @GET("kamar")
    Call<List<HomeModel>> getKamar();
    @GET("transaksi")
    Call<List<MenungguModel>> getMenunggu();


    // lets make our model class of json data .
}
