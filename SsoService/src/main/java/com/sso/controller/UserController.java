package com.sso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@RequestMapping("/index")
	public String Dashboard() {
		return "dashboard";
	}
}
