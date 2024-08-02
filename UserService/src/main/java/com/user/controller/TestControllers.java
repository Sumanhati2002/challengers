package com.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControllers {
	@GetMapping
	public String TestWorking() {
		return "Welcome To User Service";
	}
}
