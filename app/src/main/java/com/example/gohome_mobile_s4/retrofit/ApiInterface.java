package com.example.gohome_mobile_s4.retrofit;

import com.example.gohome_mobile_s4.Model.HomeModel;
import com.example.gohome_mobile_s4.Model.booking.Booking;
import com.example.gohome_mobile_s4.Model.login.Login;
import com.example.gohome_mobile_s4.Model.profile.Profile;
import com.example.gohome_mobile_s4.Model.register.Register;
import com.example.gohome_mobile_s4.Model.total.Total;
import com.example.gohome_mobile_s4.Model.transaksiNik.TransaksiNik;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
    String BASE_URL = "http://192.168.1.18:8000/api/";

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

//    @FormUrlEncoded
//    @POST("filter")
//    Call<List<HomeModel>> getKamarTerpilih(
//            @Field("tanggal_checkin") String tanggal_checkin,
//            @Field("tanggal_checkout") String tanggal_checkout
//    );

    @FormUrlEncoded
    @POST("transaksi_id")
    Call<TransaksiNik> postTransaksi(
            @Field("nik") String nik);


    @FormUrlEncoded
    @POST("updateProfile")
    Call<Profile> updateAkun(
            @Field("nik") String nik,
            @Field("nama_pengunjung") String nama_pengunjung,
            @Field("email") String email,
            @Field("telepon") String telepon);
    // lets make our model class of json data .

//    @GET("filter_tersedia")
//    Call<FilterTersediaItem> filterTersedia(
//            @Query("tanggal_checkin_awal") String tanggalCheckinAwal,
//            @Query("tanggal_checkin_akhir") String tanggalCheckinAkhir,
//            @Query("tanggal_checkout_awal") String tanggalCheckoutAwal,
//            @Query("tanggal_checkout_akhir") String tanggalCheckoutAkhir
//    );
    @FormUrlEncoded
    @POST("checkout/{id}")
    Call<Total> getTotal(
            @Path("id") int id,
            @Field("tanggal_checkin") String tanggal_checkin,
            @Field("tanggal_checkout") String tanggal_checkout
    );

//    @GET("users/{user_id}/playlists")
//    Call<List<Playlist> getUserPlaylists(@Path(value = "user_id", encoded = true) String userId);


    @FormUrlEncoded
    @POST("data_transaksi")
    Call<Booking> dataTransaksi(
            @Field("tanggal_checkin") String tanggal_checkin,
            @Field("tanggal_checkout") String tanggal_checkout,
            @Field("total") String total,
            @Field("nik") String nik,
            @Field("id_kamar") String id_kamar
    );

}
