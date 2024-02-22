package com.st.medhead.backend.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.st.medhead.jwt.JWTService;

@RestController
public class LoginController {
/*
	private JWTService jwtService;
	
	public LoginController(JWTService jwtService) {
		this.jwtService = jwtService;
	}

	
	@PostMapping("/login")
	public String getToken(Authentication authentication) {
		try {	
			String token = jwtService.generateToken(authentication);
			return token;
		}
		catch(Exception e) {
			return e.toString();
		}
		
	}
*/
}