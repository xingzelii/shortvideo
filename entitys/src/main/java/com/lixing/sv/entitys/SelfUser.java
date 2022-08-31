package com.lixing.sv.entitys;

public class SelfUser extends UserCommen{
	private String password;
	private String token;



	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
