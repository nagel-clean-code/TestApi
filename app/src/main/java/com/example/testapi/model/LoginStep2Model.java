package com.example.testapi.model;

import com.google.gson.annotations.SerializedName;

public class LoginStep2Model{

	@SerializedName("settings")
	private Object settings;

	@SerializedName("normalizedPhone")
	private String normalizedPhone;

	@SerializedName("errorMessageCode")
	private String errorMessageCode;

	@SerializedName("errorMessage")
	private String errorMessage;

	@SerializedName("successful")
	private boolean successful;

	public void setSettings(Object settings){
		this.settings = settings;
	}

	public Object getSettings(){
		return settings;
	}

	public void setNormalizedPhone(String normalizedPhone){
		this.normalizedPhone = normalizedPhone;
	}

	public String getNormalizedPhone(){
		return normalizedPhone;
	}

	public void setErrorMessageCode(String errorMessageCode){
		this.errorMessageCode = errorMessageCode;
	}

	public String getErrorMessageCode(){
		return errorMessageCode;
	}

	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage(){
		return errorMessage;
	}

	public void setSuccessful(boolean successful){
		this.successful = successful;
	}

	public boolean isSuccessful(){
		return successful;
	}

	@Override
 	public String toString(){
		return 
			"LoginStep2Model{" + 
			"settings = '" + settings + '\'' + 
			",normalizedPhone = '" + normalizedPhone + '\'' + 
			",errorMessageCode = '" + errorMessageCode + '\'' + 
			",errorMessage = '" + errorMessage + '\'' + 
			",successful = '" + successful + '\'' + 
			"}";
		}
}