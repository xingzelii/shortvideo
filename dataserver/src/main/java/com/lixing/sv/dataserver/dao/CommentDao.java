package com.lixing.sv.dataserver.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lixing.sv.entitys.Coment;

@Mapper
public interface CommentDao {
	public int addComment(Coment c);
	public int delectComment(long id);
	public long queryNewId();
}
