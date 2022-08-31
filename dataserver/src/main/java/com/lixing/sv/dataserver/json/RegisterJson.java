package com.lixing.sv.dataserver.json;

import org.springframework.stereotype.Component;

import com.lixing.sv.dataserver.jsonutils.JsonUtil;

public class RegisterJson extends JsonUtil {
	private Long userId;
	private String token;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
