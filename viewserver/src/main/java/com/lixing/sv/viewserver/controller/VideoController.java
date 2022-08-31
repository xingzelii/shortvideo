package com.lixing.sv.viewserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lixing.sv.entitys.Video;
import com.lixing.sv.viewserver.service.VideoService;

@RestController
public class VideoController {
	
	@Autowired
	VideoService videoService;
	
	@RequestMapping("/video")
	public Object getVideos(){
		List<Video> lv=videoService.getVideos();
		return lv;
	}
}
