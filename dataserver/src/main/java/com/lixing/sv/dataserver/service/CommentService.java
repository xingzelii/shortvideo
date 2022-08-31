package com.lixing.sv.dataserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixing.sv.dataserver.dao.CommentDao;
import com.lixing.sv.entitys.Coment;

@Service
public class CommentService {

	@Autowired
	CommentDao commentDao;
	
	public void addComment(Coment c) {
		commentDao.addComment(c);
	}
	
	public void delectComment(Long id) {
		commentDao.delectComment(id);
	}
	
	public long queryNewId() {
		return commentDao.queryNewId();
	}
}
