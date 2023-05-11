package com.example.gohome_mobile_s4.retrofit;

import com.example.gohome_mobile_s4.MenungguFragment;
import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.Model.MenungguModel;
import com.example.gohome_mobile_s4.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    String BASE_URL = "http://192.168.1.25:8000/api/";
    @GET("kamar")
    Call<List<HomeModel>> getKamar();
    @GET("transaksi")
    Call<List<MenungguModel>> getMenunggu();
    // lets make our model class of json data .
}
