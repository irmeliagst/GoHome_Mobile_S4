package com.example.gohome_mobile_s4.Model;

public class HomeModel {
    private  int item_image;
    private String jenis_kamar;
    private String harga;

    public HomeModel(int item_image, String jenis_kamar, String harga) {
        this.item_image = item_image;
        this.jenis_kamar = jenis_kamar;
        this.harga = harga;
    }
    public int getItem_image() {
        return item_image;
    }

    public String getjenis_kamar() {
        return jenis_kamar;
    }

    public String getHarga() {
        return harga;
    }


    public int getType() {
        return 0;
    }
}
