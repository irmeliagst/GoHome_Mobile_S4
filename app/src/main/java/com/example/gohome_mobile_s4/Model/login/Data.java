package com.example.gohome_mobile_s4.Model.login;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("nik")
    private long nik;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("nama_pengunjung")
    private String namaPengunjung;

    @SerializedName("telepon")
    private String telepon;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("email")
    private String email;

    @SerializedName("token")
    private String token;
    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;
    public void setNik(long nik){
        this.nik = nik;
    }

    public long getNik(){
        return nik;
    }

    public void setUpdatedAt(String updatedAt){
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt(){
        return updatedAt;
    }

    public void setNamaPengunjung(String namaPengunjung){
        this.namaPengunjung = namaPengunjung;
    }

    public String getNamaPengunjung(){
        return namaPengunjung;
    }
    public void setTelepon(String telepon){
        this.telepon = telepon;
    }

    public String getTelepon(){
        return telepon;
    }

    public void setCreatedAt(String createdAt){
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setToken(String token){
        this.token = token;
    }

    public String getToken(){
        return token;
    }
    public void setSuccess(boolean success){
        this.success = success;
    }

    public boolean isSuccess(){
        return success;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

}
