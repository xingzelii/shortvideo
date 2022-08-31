package com.lixing.sv.dataserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixing.sv.dataserver.dao.VideoDao;
import com.lixing.sv.entitys.VideoForDao;

@Service
public class PublishService {
	@Autowired VideoDao videoDao;
	public long queryMaxId() {
		return videoDao.queryMaxId();
	}
	public int addVideo(VideoForDao v) {
		return videoDao.addVideo(v);
	}
}
