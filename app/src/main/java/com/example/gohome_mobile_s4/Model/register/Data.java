package com.example.gohome_mobile_s4.Model.register;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("nama_pengunjung")
	private String namaPengunjung;

	@SerializedName("telepon")
	private String telepon;

	@SerializedName("email")
	private String email;

	@SerializedName("token")
	private String token;

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

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}
}