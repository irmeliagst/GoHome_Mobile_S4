package com.example.gohome_mobile_s4.Model;

import java.sql.Date;
import java.text.DateFormat;

public class TransaksiModel{
    private  int gambar_kamar;
    private String jenis_kamar;
    private String total;
    private String tanggal_chekin;
    private String tanggal_chekout;

    public TransaksiModel(int gambar_kamar, String jenis_kamar, String total, String tanggal_chekin, String tanggal_chekout) {
        this.gambar_kamar = gambar_kamar;
        this.jenis_kamar = jenis_kamar;
        this.total = total;
        this.tanggal_chekin = tanggal_chekin;
        this.tanggal_chekout = tanggal_chekout;
    }

    public int getGambar_kamar() {
        return gambar_kamar;
    }

    public String getJenis_kamar() {
        return jenis_kamar;
    }

    public String getTotal() {
        return total;
    }

    public String getTanggal_chekin() {
        return tanggal_chekin;
    }

    public String getTanggal_chekout() {
        return tanggal_chekout;
    }
}
