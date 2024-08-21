package com.example.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController{
	
	// Default
	@GetMapping
	public String defaultAPI() {
		return "Account API is up and running";
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	@GetMapping("/token")
	public void token() {
		
	}
	
}