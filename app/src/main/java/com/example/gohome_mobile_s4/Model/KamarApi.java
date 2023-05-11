package com.example.gohome_mobile_s4.Model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class KamarApi{

	@SerializedName("KamarApi")
	private List<KamarApiItem> kamarApi;

	public void setKamarApi(List<KamarApiItem> kamarApi){
		this.kamarApi = kamarApi;
	}

	public List<KamarApiItem> getKamarApi(){
		return kamarApi;
	}
}