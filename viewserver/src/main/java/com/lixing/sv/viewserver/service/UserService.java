package com.lixing.sv.viewserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixing.sv.entitys.SelfUser;
import com.lixing.sv.viewserver.client.UserClientFeign;

@Service
public class UserService {
	@Autowired
	UserClientFeign userClientFeign;
	
	public List<SelfUser> getUsers() {
		return userClientFeign.listUsers();
	}
}
