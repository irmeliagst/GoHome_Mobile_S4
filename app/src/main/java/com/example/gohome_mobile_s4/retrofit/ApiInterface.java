package com.example.gohome_mobile_s4.retrofit;

import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.Model.login.Login;
import com.example.gohome_mobile_s4.Model.register.Register;
import com.example.gohome_mobile_s4.Model.transaksi.TransaksiModelItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    String BASE_URL = "http://192.168.43.28:8000/api/";

    @FormUrlEncoded
    @POST("login")
    Call<Login>login(
            @Field("email") String email,
            @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Call<Register>register(
            @Field("nik") String nik,
            @Field("nama_pengunjung") String nama_pengunjung,
            @Field("email") String email,
            @Field("password") String password,
            @Field("telepon") String telepon);

    @GET("kamar")
    Call<List<HomeModel>> getKamar();

    @GET("transaksi")
    Call<List<TransaksiModelItem>> getTransaksi();


    // lets make our model class of json data .
}
