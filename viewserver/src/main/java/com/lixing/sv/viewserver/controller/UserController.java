package com.lixing.sv.viewserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lixing.sv.entitys.SelfUser;
import com.lixing.sv.viewserver.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/user")
	public Object getUsers(Model m){
		List<SelfUser> lu=userService.getUsers();
		m.addAttribute("lu",lu);
		return "user";
	}
	
}
