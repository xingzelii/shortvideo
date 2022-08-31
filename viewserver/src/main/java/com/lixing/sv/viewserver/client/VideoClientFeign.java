package com.lixing.sv.viewserver.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import com.lixing.sv.entitys.Video;
 
@FeignClient(value = "DATA-SERVICE")
public interface VideoClientFeign {
    @GetMapping("/videos")
    public List<Video> listVideos();
}