package com.example.gohome_mobile_s4.Model.total;

import com.google.gson.annotations.SerializedName;

public class Total{

	@SerializedName("total")
	private int total;
	public void setTotal(int total){
		this.total = total;
	}
	public int getTotal(){
		return total;
	}

//
//	@SerializedName("harga")
//	private int harga;
//	public void setHarga(int harga){
//		this.harga = harga;
//	}
//	public int getHarga(){
//		return harga;
//	}


}