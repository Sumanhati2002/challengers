package com.sso.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authorization {
	@RequestMapping("/welcome")
	public String welcome() {
		String text="This is private Page";
		text+="this is used to generate authonticate";
		return text;
	}

}
