package com.ddb.test.linux.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinuxDemoController {

	@GetMapping("/aa")
	public String getDemo() {
		return "我是不是很帅?是的!";
	}
	
}
