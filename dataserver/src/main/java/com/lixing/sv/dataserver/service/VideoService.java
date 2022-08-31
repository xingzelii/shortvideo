package com.lixing.sv.dataserver.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lixing.sv.entitys.Video;

@Service
public class VideoService {
    @Value("${server.port}")
    String port;
     
    public List<Video> listVideos(){
        List<Video> ps = new ArrayList<>();
        ps.add(new Video());
        ps.add(new Video());
        ps.add(new Video());
        return ps;
    }
    
    
}