package com.example.gohome_mobile_s4.Model;

public class HomeModel {
    private  int item_image;
    private String Jkamar;
    private String harga;

    public HomeModel(int item_image, String Jkamar, String harga) {
        this.item_image = item_image;
        this.Jkamar = Jkamar;
        this.harga = harga;
    }
    public int getItem_image() {
        return item_image;
    }

    public String getJkamar() {
        return Jkamar;
    }

    public String getHarga() {
        return harga;
    }


    public int getType() {
        return 0;
    }
}
