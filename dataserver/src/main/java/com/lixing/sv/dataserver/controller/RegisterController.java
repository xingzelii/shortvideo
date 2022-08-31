package com.lixing.sv.dataserver.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lixing.sv.dataserver.json.RegisterJson;
import com.lixing.sv.dataserver.service.RegisterService;
import com.lixing.sv.dataserver.utils.MD5;
import com.lixing.sv.dataserver.utils.RedisUtil;
import com.lixing.sv.entitys.SelfUser;

@RestController
public class RegisterController {
	@Autowired
	RegisterService registerService;
	@Autowired
	RedisUtil redisUtil;
	@Autowired
	MD5 md5;
	@RequestMapping("/register")
	public Object regist(HttpServletRequest request) {
		long id;
		if(redisUtil.hasKey("id")) {
			id=(long) redisUtil.get("id");
			//System.out.println("read from redis");
		}else {
			id=registerService.queryMaxId()+1;
			//System.out.println("read from mysql");
		}
		String token=md5.queryMD5token(id);
		RegisterJson rj=new RegisterJson();
		SelfUser su=new SelfUser();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		su.setId(id);
		su.setName(name);
		su.setPassword(password);
		try {
			su.setId(id);
			su.setToken(token);
			redisUtil.set("id", id+1);
			registerService.regist(su);
			redisUtil.set(token, id);
			rj.setStatusCode(0);
			rj.setStatusMsg("ok");
			rj.setUserId(id);
			rj.setToken(token);
			//System.out.println(id);
		}catch(Exception e) {
			rj.setStatusCode(1);
			rj.setStatusMsg("error");
		}
		return rj;
	}
}