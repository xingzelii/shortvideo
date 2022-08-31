package com.lixing.sv.viewserver.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lixing.sv.viewserver.service.PublishService;
import com.lixing.sv.viewserver.uils.JsonUtil;
import com.lixing.sv.viewserver.uils.ReadToken;


@Controller
public class PublishController {
	@Autowired ReadToken readtoken;
	@Autowired PublishService publishservice;
	@RequestMapping("/publishpage")
    public Object uploadPage(Model m) {
        return "publish";
    }
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Object upload(HttpServletRequest req, @RequestParam("file") MultipartFile file,Model m
    		,@RequestParam("token") String token,@RequestParam("title") String title) {
			
			JsonUtil ju=new JsonUtil();
			long id=readtoken.read(token);
			if(id!=-1) {
				try {
	                String fileName = System.currentTimeMillis()+file.getOriginalFilename();
	                String destFileName="E:\\staticsource"+File.separator+fileName;
	                String url="http://localhost:8012/"+fileName;
	                File destFile = new File(destFileName);
	                destFile.getParentFile().mkdirs();
	                file.transferTo(destFile);             
	                m.addAttribute("fileName",fileName);
	                publishservice.publish(id, url, title);
	                ju.setStatusCode(0);
	                ju.setStatusMsg("ok");
	            } catch (FileNotFoundException e) {
	                ju.setStatusCode(1);
	                ju.setStatusMsg("upload error");
	            } catch (IOException e) {
	            	ju.setStatusCode(1);
	                ju.setStatusMsg("store error");
	            }
			}
			else {
				ju.setStatusCode(1);
                ju.setStatusMsg("token error");
			}
			return "video";
    }   
}
