package com.lixing.sv.dataserver.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lixing.sv.dataserver.dao.UserDao;
import com.lixing.sv.entitys.OtherUser;
import com.lixing.sv.entitys.SelfUser;
 
 
@Service
public class UserService {
    @Value("${server.port}")
    String port;
     
    @Autowired
    UserDao userDao;
    public List<OtherUser> listUsers(long id){
    	List<OtherUser> ps= userDao.queryById(id);
        return ps;
    }
}