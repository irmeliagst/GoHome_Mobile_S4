package com.example.gohome_mobile_s4.Model;

public class HomeModel {
    private  int item_image;
    private String jenis_kamar;
    private int harga;
    private  int id_kamar;
    private String deskripsi;

    private  String nomer_kamar;



        public HomeModel(int item_image, String jenis_kamar, int harga, int id_kamar, String deskripsi, String nomer_kamar) {
        this.item_image = item_image;
        this.jenis_kamar = jenis_kamar;
        this.harga = harga;
        this.id_kamar = id_kamar;
        this.deskripsi = deskripsi;
        this.nomer_kamar = nomer_kamar;
    }
    public int getItem_image() {
        return item_image;
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
