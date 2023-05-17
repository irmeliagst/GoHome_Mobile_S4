package com.example.gohome_mobile_s4.Model.filter;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FilterTersedia{

	@SerializedName("FilterTersedia")
	private List<FilterTersediaItem> filterTersedia;

	public void setFilterTersedia(List<FilterTersediaItem> filterTersedia){
		this.filterTersedia = filterTersedia;
	}

	public List<FilterTersediaItem> getFilterTersedia(){
		return filterTersedia;
	}
}