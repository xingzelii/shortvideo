package com.lixing.sv.viewserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lixing.sv.viewserver.client.PublishClientFeign;


@Service
public class PublishService {
	@Autowired
	PublishClientFeign publishClientFeign;
	
	public void publish(long id,String url,String title) {
		publishClientFeign.publish(id,url,title);
	}
}
