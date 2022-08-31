package com.lixing.sv.dataserver.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
public class MD5 {
	@Autowired
	RedisUtil redisUtil;
	
	public String queryMD5token(long id) {
		String salt;
		Date date = new Date();
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		String time=dateFormat.format(date);
		if(redisUtil.hasKey("salt")) {
			salt=(String) redisUtil.get("salt");
		}else {
			salt="lixing";
			redisUtil.set("salt", salt);
		}	
		return DigestUtils.md5DigestAsHex((time+salt+id).getBytes());	
	}
}
