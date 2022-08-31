package com.lixing.sv.dataserver.json;

import java.util.List;

import com.lixing.sv.dataserver.jsonutils.JsonUtil;
import com.lixing.sv.entitys.OtherUser;

public class UserJson extends JsonUtil{
	private List<OtherUser> user;

	public List<OtherUser> getUser() {
		return user;
	}

	public void setUser(List<OtherUser> user) {
		this.user = user;
	}
}
