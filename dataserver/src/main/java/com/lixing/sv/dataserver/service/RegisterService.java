package com.lixing.sv.dataserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lixing.sv.dataserver.dao.UserDao;
import com.lixing.sv.entitys.SelfUser;

@Service
public class RegisterService {
	@Value("${server.port}")
    String port;
	@Autowired
    UserDao userDao;
	
	public int regist(SelfUser su) {
		return userDao.addUser(su);
	}
	public long queryMaxId() {
		return userDao.queryMaxId()==null?0:userDao.queryMaxId();
	}
}
