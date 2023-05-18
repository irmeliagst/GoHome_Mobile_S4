package com.example.gohome_mobile_s4.Model.booking;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("nik")
	private String nik;

	@SerializedName("total")
	private String total;

	@SerializedName("tanggal_checkout")
	private String tanggalCheckout;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("tanggal_checkin")
	private String tanggalCheckin;

	@SerializedName("id")
	private int id;

	@SerializedName("id_kamar")
	private String idKamar;

	@SerializedName("status")
	private String status;

	public void setNik(String nik){
		this.nik = nik;
	}

	public String getNik(){
		return nik;
	}

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}

	public void setTanggalCheckout(String tanggalCheckout){
		this.tanggalCheckout = tanggalCheckout;
	}

	public String getTanggalCheckout(){
		return tanggalCheckout;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setTanggalCheckin(String tanggalCheckin){
		this.tanggalCheckin = tanggalCheckin;
	}

	public String getTanggalCheckin(){
		return tanggalCheckin;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIdKamar(String idKamar){
		this.idKamar = idKamar;
	}

	public String getIdKamar(){
		return idKamar;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}