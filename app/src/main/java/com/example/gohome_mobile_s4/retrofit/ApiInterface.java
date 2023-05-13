package com.example.gohome_mobile_s4.retrofit;

import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.Model.TransaksiModel;
import com.example.gohome_mobile_s4.Model.login.Data;
import com.example.gohome_mobile_s4.Model.register.RegisterRespon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    String BASE_URL = "http://192.168.1.25:8000/api/";

    @FormUrlEncoded
    @POST("login")
    Call<Data>login(
            @Field("email") String email,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<RegisterRespon>register(
            @Field("nik") String nik,
            @Field("nama_pengunjung") String nama_pengunjung,
            @Field("email") String email,
            @Field("password") String password,
            @Field("telepon") String telepon);

    @GET("kamar")
    Call<List<HomeModel>> getKamar();

    @GET("transaksi")
    Call<List<TransaksiModel>> getTransaksi();


    // lets make our model class of json data .
}
