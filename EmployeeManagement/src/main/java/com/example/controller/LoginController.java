package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String getLogin() {
		System.out.println("ログイン画面GET");
		return "login/login";
	}

	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/employee/list";
	}

}