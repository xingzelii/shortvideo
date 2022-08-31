package com.lixing.sv.dataserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lixing.sv.dataserver.service.VideoService;
import com.lixing.sv.entitys.Video;

@RestController
public class VideoController {
  
    @Autowired VideoService videoService;
     
    @RequestMapping("/videos")
    public Object videos() {
        List<Video> ps = videoService.listVideos();
        return ps;
    }
}
