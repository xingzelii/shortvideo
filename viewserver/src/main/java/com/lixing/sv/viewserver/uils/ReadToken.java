package com.lixing.sv.viewserver.uils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadToken {
	@Autowired
	RedisUtil redisutil;
	
	public long read(String token) {
		try {
			long id=(long) redisutil.get(token);
			return id;
		}catch(Exception e) {
			System.out.println("can't read");
			return -1;
		}
	}
}
