package com.example.gohome_mobile_s4.Model.transaksi;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class TransaksiModel{

	@SerializedName("TransaksiModel")
	private List<TransaksiModelItem> transaksiModel;

	public void setTransaksiModel(List<TransaksiModelItem> transaksiModel){
		this.transaksiModel = transaksiModel;
	}

	public List<TransaksiModelItem> getTransaksiModel(){
		return transaksiModel;
	}
}