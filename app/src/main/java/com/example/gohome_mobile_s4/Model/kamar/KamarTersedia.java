package com.example.gohome_mobile_s4.Model.kamar;

public class KamarTersedia {
    private  int item_image;
    private String jenis_kamar;
    private String harga;

    public KamarTersedia(int item_image, String jenis_kamar, String harga) {
        this.item_image = item_image;
        this.jenis_kamar = jenis_kamar;
        this.harga = harga;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }

    public String getJenis_kamar() {
        return jenis_kamar;
    }

    public void setJenis_kamar(String jenis_kamar) {
        this.jenis_kamar = jenis_kamar;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
