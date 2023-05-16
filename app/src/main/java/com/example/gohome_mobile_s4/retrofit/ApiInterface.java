package com.example.gohome_mobile_s4.retrofit;

import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.Model.login.Login;
import com.example.gohome_mobile_s4.Model.profile.Profile;
import com.example.gohome_mobile_s4.Model.register.Register;
import com.example.gohome_mobile_s4.Model.transaksi.TransaksiModelItem;
import com.example.gohome_mobile_s4.Model.transaksiNik.DataItem;
import com.example.gohome_mobile_s4.Model.transaksiNik.TransaksiNik;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    String BASE_URL = "http://10.10.177.11:8000/api/";

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

    @FormUrlEncoded
    @POST("transaksi_id")
    Call<TransaksiNik> postTransaksi(
            @Field("nik") String nik);
    @FormUrlEncoded
    @POST("updateProfile")
    Call<Profile>updateAkun(
            @Field("nama_pengunjung") String nama_pengunjung,
            @Field("email") String email,
            @Field("password") String password,
            @Field("telepon") String telepon);


    // lets make our model class of json data .
}
