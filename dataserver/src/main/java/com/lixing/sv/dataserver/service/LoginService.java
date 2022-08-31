package com.lixing.sv.dataserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lixing.sv.dataserver.dao.UserDao;
import com.lixing.sv.entitys.SelfUser;

@Service
public class LoginService {
	@Value("${server.port}")
    String port;
	
	@Autowired
    UserDao userDao;
	
	public SelfUser quertByName(String name) {
		if(userDao.queryByName(name).size()>0) {
			return userDao.queryByName(name).get(0);
		}
		else return new SelfUser();
	}
}
