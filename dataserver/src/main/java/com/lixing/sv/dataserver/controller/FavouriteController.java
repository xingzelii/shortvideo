package com.lixing.sv.dataserver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lixing.sv.dataserver.jsonutils.JsonUtil;
import com.lixing.sv.dataserver.service.FavouriteService;

@RestController
public class FavouriteController {
	@Autowired
	FavouriteService fs;
	
	@RequestMapping("/favorite/action")
	public Object favourite(HttpServletRequest request) {
		long uid,id,action;
		uid=Long.parseLong(request.getParameter("uid"));
		id=Long.parseLong(request.getParameter("id"));
		action=Long.parseLong(request.getParameter("action"));
		JsonUtil ju=new JsonUtil();
		if(action==1)fs.fav(uid, id);
		else if(action==2)fs.disFav(uid,id);
		ju.setStatusCode(0);
		ju.setStatusMsg("ok");
		return ju;
	}
}
