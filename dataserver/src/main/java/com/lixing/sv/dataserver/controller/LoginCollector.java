package com.lixing.sv.dataserver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lixing.sv.dataserver.json.RegisterJson;
import com.lixing.sv.dataserver.service.LoginService;
import com.lixing.sv.dataserver.utils.MD5;
import com.lixing.sv.entitys.SelfUser;

@RestController
public class LoginCollector {
	@Autowired
	LoginService loginService;
	@Autowired
	MD5 md5;
	@RequestMapping("/login")
	public Object login(HttpServletRequest request) {
		RegisterJson rj=new RegisterJson();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		try {
			SelfUser su=loginService.quertByName(name);
			if(su.getPassword().equals(password)) {
				rj.setStatusCode(0);
				rj.setStatusMsg("ok");
				rj.setUserId(su.getId());
				rj.setToken(su.getToken());
			}
		}catch(Exception e) {
			rj.setStatusCode(1);
			rj.setStatusMsg("error");
		}
		return rj;
	}
}
