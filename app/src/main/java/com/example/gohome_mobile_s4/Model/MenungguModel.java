package com.example.gohome_mobile_s4.Model;

public class MenungguModel {
    private  int imageview;
    private String jenis_kamar;
    private String total;
    private String status;

    public int getImageview() {
        return imageview;
    }

    public String getJenis_kamar() {
        return jenis_kamar;
    }

    public String getTotal() {
        return total;
    }

    public String getStatus() {
        return status;
    }

    public MenungguModel(int imageview, String jenis_kamar, String total, String status) {
        this.imageview = imageview;
        this.jenis_kamar = jenis_kamar;
        this.total = total;
        this.status = status;
    }



}
