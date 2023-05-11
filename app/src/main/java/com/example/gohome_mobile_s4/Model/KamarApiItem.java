package com.example.gohome_mobile_s4.Model;

import com.google.gson.annotations.SerializedName;

public class KamarApiItem{

	@SerializedName("jenis_kasur")
	private String jenisKasur;

	@SerializedName("status_kamar")
	private String statusKamar;

	@SerializedName("harga")
	private int harga;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("gambar_kamar")
	private String gambarKamar;

	@SerializedName("nomer_kamar")
	private String nomerKamar;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("deskripsi")
	private String deskripsi;

	@SerializedName("id_kamar")
	private int idKamar;

	@SerializedName("jenis_kamar")
	private String jenisKamar;

	public void setJenisKasur(String jenisKasur){
		this.jenisKasur = jenisKasur;
	}

	public String getJenisKasur(){
		return jenisKasur;
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

	public void setJenisKamar(String jenisKamar){
		this.jenisKamar = jenisKamar;
	}

	public String getJenisKamar(){
		return jenisKamar;
	}
}