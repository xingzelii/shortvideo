package com.lixing.sv.viewserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixing.sv.entitys.Video;
import com.lixing.sv.viewserver.client.VideoClientFeign;

@Service
public class VideoService {
	@Autowired
	VideoClientFeign videoClientFeign;
	
	public List<Video> getVideos(){
		return videoClientFeign.listVideos();
	}
	
}
