package com.example.gohome_mobile_s4.Model.login;
import com.google.gson.annotations.SerializedName;
public class Login{
	@SerializedName("data")
	private LoginData loginData;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(LoginData loginData){
		this.loginData = loginData;
	}

	public LoginData getData(){
		return loginData;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}