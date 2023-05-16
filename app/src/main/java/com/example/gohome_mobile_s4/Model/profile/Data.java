package com.example.gohome_mobile_s4.Model.profile;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("nik")
	private String nik;

	@SerializedName("password")
	private String password;

	@SerializedName("nama_pengunjung")
	private String namaPengunjung;

	@SerializedName("telepon")
	private String telepon;

	@SerializedName("email")
	private String email;

	public void setNik(String nik){
		this.nik = nik;
	}

	public String getNik(){
		return nik;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setNamaPengunjung(String namaPengunjung){
		this.namaPengunjung = namaPengunjung;
	}

	public String getNamaPengunjung(){
		return namaPengunjung;
	}

	public void setTelepon(String telepon){
		this.telepon = telepon;
	}

	public String getTelepon(){
		return telepon;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}