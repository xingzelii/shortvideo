package com.lixing.sv.dataserver.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lixing.sv.entitys.OtherUser;
import com.lixing.sv.entitys.SelfUser;



@Mapper
public interface UserDao {
	List<SelfUser> findAll();
	int addUser(SelfUser u);
	Long queryMaxId();
	List<SelfUser> queryByName(String name);
	List<OtherUser> queryById(Long id);
	Long queryBytoken();
}
