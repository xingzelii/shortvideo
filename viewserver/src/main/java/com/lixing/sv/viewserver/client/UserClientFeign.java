package com.lixing.sv.viewserver.client;

import java.util.List;
 
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.lixing.sv.entitys.SelfUser;
 

 
@FeignClient(value = "DATA-SERVICE")
public interface UserClientFeign {
 
    @GetMapping("/users")
    public List<SelfUser> listUsers();
}