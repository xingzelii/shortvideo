package com.lixing.sv.dataserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixing.sv.dataserver.dao.VideoDao;
import com.lixing.sv.dataserver.utils.RedisUtil;

@Service
public class FavouriteService {
	@Autowired
	VideoDao videoDao;
	@Autowired
	RedisUtil redisutil;
	
	public void fav(long uid,long id) {
		videoDao.favourite(id);
		Long userid=uid;
		redisutil.sSet(userid.toString(), id);
	}

	public void disFav(long uid, long id) {
		videoDao.disfavourite(id);
		Long userid=uid;
		redisutil.setRemove(userid.toString(), id);
	}


}
