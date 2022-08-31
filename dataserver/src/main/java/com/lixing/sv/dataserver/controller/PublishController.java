package com.lixing.sv.dataserver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lixing.sv.dataserver.jsonutils.JsonUtil;
import com.lixing.sv.dataserver.service.PublishService;
import com.lixing.sv.entitys.VideoForDao;

@RestController
public class PublishController {
	
	@Autowired
	PublishService publishService;
	
	@RequestMapping("/publish")
	public Object publish(HttpServletRequest request) {
		long id=Long.parseLong(request.getParameter("id"));
		String url=request.getParameter("url");
		String title=request.getParameter("title");
		VideoForDao vfd=new VideoForDao();
		vfd.setUrl(url);
		vfd.setUserid(id);
		vfd.setTitle(title);
		vfd.setId(publishService.queryMaxId()+1);
		publishService.addVideo(vfd);
		JsonUtil ju=new JsonUtil();
		ju.setStatusCode(0);
		ju.setStatusMsg("ok");
		return  ju;
	}
}
