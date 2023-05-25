package com.example.gohome_mobile_s4.Model;

public class HomeModel {
    private  String gambar_kamar;
    private String jenis_kamar;
    private int harga;
    private  int id_kamar;
    private String deskripsi;

    private  String nomer_kamar;



        public HomeModel(String gambar_kamar, String jenis_kamar, int harga, int id_kamar, String deskripsi, String nomer_kamar) {
        this.gambar_kamar = gambar_kamar;
        this.jenis_kamar = jenis_kamar;
        this.harga = harga;
        this.id_kamar = id_kamar;
        this.deskripsi = deskripsi;
        this.nomer_kamar = nomer_kamar;
    }
    public String getGambar_kamar() {
        return gambar_kamar;
    }

    public String getjenis_kamar() {
        return jenis_kamar;
    }

    public int getHarga() {
        return harga;
    }

    public int getId_kamar() { return id_kamar; }

    public String getDeskripsi() {
        return deskripsi;
    }

    public  String getNomer_kamar(){
            return nomer_kamar;
    }

    public int getType() {
        return 0;
    }
}
