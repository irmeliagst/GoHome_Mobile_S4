package com.example.gohome_mobile_s4.Model.filter;

import com.google.gson.annotations.SerializedName;

public class FilterTersediaItem{

	@SerializedName("tanggal_checkout")
	private String tanggalCheckout;

	@SerializedName("nomer_kamar")
	private String nomerKamar;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id_transaksi")
	private int idTransaksi;

	@SerializedName("jenis_kamar")
	private String jenisKamar;

	@SerializedName("jenis_kasur")
	private String jenisKasur;

	@SerializedName("nik")
	private long nik;

	@SerializedName("total")
	private int total;

	@SerializedName("status_kamar")
	private String statusKamar;

	@SerializedName("harga")
	private int harga;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("gambar_kamar")
	private String gambarKamar;

	@SerializedName("tanggal_checkin")
	private String tanggalCheckin;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("id_kamar")
	private int idKamar;

	@SerializedName("status")
	private String status;

	public void setTanggalCheckout(String tanggalCheckout){
		this.tanggalCheckout = tanggalCheckout;
	}

	public String getTanggalCheckout(){
		return tanggalCheckout;
	}

	public void setNomerKamar(String nomerKamar){
		this.nomerKamar = nomerKamar;
	}

	public String getNomerKamar(){
		return nomerKamar;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
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

	public void setJenisKasur(String jenisKasur){
		this.jenisKasur = jenisKasur;
	}

	public String getJenisKasur(){
		return jenisKasur;
	}

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

	public void setStatusKamar(String statusKamar){
		this.statusKamar = statusKamar;
	}

	public String getStatusKamar(){
		return statusKamar;
	}

	public void setHarga(int harga){
		this.harga = harga;
	}

	public int getHarga(){
		return harga;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setGambarKamar(String gambarKamar){
		this.gambarKamar = gambarKamar;
	}

	public String getGambarKamar(){
		return gambarKamar;
	}

	public void setTanggalCheckin(String tanggalCheckin){
		this.tanggalCheckin = tanggalCheckin;
	}

	public String getTanggalCheckin(){
		return tanggalCheckin;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	public void setIdKamar(int idKamar){
		this.idKamar = idKamar;
	}

	public int getIdKamar(){
		return idKamar;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}