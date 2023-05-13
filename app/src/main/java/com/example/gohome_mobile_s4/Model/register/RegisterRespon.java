package com.example.gohome_mobile_s4.Model.register;

import com.google.gson.annotations.SerializedName;

public class RegisterRespon {
    @SerializedName("success")
    private boolean success;

    @SerializedName("massage")
    private String massage;

    @SerializedName("nama_pengunjung")
    private String namaPengunjung;

    @SerializedName("telepon")
    private String telepon;

    @SerializedName("email")
    private String email;

    @SerializedName("token")
    private String token;


    public boolean isSuccess() {
        return success;
    }

    public String getMassage() {
        return massage;
    }

    public String getNamaPengunjung() {
        return namaPengunjung;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public void setNamaPengunjung(String namaPengunjung) {
        this.namaPengunjung = namaPengunjung;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
