package com.lixing.sv.viewserver.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="DATA-SERVICE")
public interface PublishClientFeign {
	@PostMapping("/publish")
	public Object publish( @RequestParam("id") long  id,
			@RequestParam("url") String url,
			@RequestParam("title") String title);
}
