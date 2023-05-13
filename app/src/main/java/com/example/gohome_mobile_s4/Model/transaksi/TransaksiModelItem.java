package com.example.gohome_mobile_s4.Model.transaksi;

import com.google.gson.annotations.SerializedName;

public class TransaksiModelItem{

	@SerializedName("nik")
	private long nik;

	@SerializedName("total")
	private int total;

	@SerializedName("tanggal_checkout")
	private String tanggalCheckout;

	@SerializedName("tanggal_checkin")
	private String tanggalCheckin;

	@SerializedName("id_transaksi")
	private int idTransaksi;

	@SerializedName("jenis_kamar")
	private String jenisKamar;

	public void setNik(long nik){
		this.nik = nik;
	}

	public long getNik(){
		return nik;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setTanggalCheckout(String tanggalCheckout){
		this.tanggalCheckout = tanggalCheckout;
	}

	public String getTanggalCheckout(){
		return tanggalCheckout;
	}

	public void setTanggalCheckin(String tanggalCheckin){
		this.tanggalCheckin = tanggalCheckin;
	}

	public String getTanggalCheckin(){
		return tanggalCheckin;
	}

	public void setIdTransaksi(int idTransaksi){
		this.idTransaksi = idTransaksi;
	}

	public int getIdTransaksi(){
		return idTransaksi;
	}

	public void setJenisKamar(String jenisKamar){
		this.jenisKamar = jenisKamar;
	}

	public String getJenisKamar(){
		return jenisKamar;
	}
}