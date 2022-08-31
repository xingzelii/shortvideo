package com.lixing.sv.dataserver.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lixing.sv.dataserver.json.UserJson;
import com.lixing.sv.dataserver.service.UserService;
import com.lixing.sv.dataserver.utils.ReadToken;
import com.lixing.sv.entitys.OtherUser;
 
  
@RestController
public class UserController {
  
    @Autowired UserService userService;
    @Autowired ReadToken readtoken;
     
    @RequestMapping("/user")
    public Object users(HttpServletRequest request) {
    	long id;
    	String token=(String) request.getParameter("token");
    	//System.out.println(token);
    	id=readtoken.read(token);
    	UserJson uj=new UserJson();
    	if(id!=-1) {
    		long user_id=Long.parseLong((String) request.getParameter("user_id"));
            List<OtherUser> ps = userService.listUsers(user_id);
            //TODO
            ps.get(0).setIsFollow(false);
            
            uj.setStatusCode(0);
            uj.setStatusMsg("ok");
            uj.setUser(ps);
    	}else {
    		uj.setStatusCode(1);
            uj.setStatusMsg("error");
    	}
    	return uj;
    }
}