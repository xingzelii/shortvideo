package com.lixing.sv.dataserver.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lixing.sv.dataserver.service.CommentService;
import com.lixing.sv.entitys.Coment;

@RestController
public class CommentController {
	@Autowired
	CommentService commentService;
	@RequestMapping("/comment/action")
	public Object commentAction(HttpServletRequest request) {
		int action=Integer.parseInt(request.getParameter("action"));
		if(action==1) {
			long uid = Long.parseLong(request.getParameter("uid"));
			String content=request.getParameter("content");
			long vid = Long.parseLong(request.getParameter("vid"));
			Coment c=new Coment();
			c.setContent(content);
			c.setVideoId(vid);
			c.setUserId(uid);
			commentService.addComment(c);
			long id=commentService.queryNewId();
		}
		if(action==2) {
			long id=Long.parseLong(request.getParameter("id"));
			commentService.delectComment(id);
		}
		return "";
	}
}
