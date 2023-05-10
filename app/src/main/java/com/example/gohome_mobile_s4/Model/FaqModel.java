package com.example.gohome_mobile_s4.Model;

public class FaqModel {
    public String judul;
    public String deskripsi;
    public boolean isVisible;

    public FaqModel(String judul, String deskripsi, boolean isVisible) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.isVisible = isVisible;
    }
}
