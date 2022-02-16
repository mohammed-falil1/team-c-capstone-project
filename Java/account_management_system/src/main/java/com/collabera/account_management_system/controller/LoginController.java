package com.collabera.account_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.collabera.account_management_system.Jwt.AuthRequest;
import com.collabera.account_management_system.Jwt.AuthResponse;
import com.collabera.account_management_system.Jwt.JwtUtil;
import com.collabera.account_management_system.Vo.AdminLoginVO;
import com.collabera.account_management_system.entity.AdminLoginEntity;
import com.collabera.account_management_system.service.AdminService;
import com.collabera.account_management_system.utility.ApplicationConstants;


@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	AdminService adminService;
	
	
	@PostMapping("/admin-login")
	public ResponseEntity<Boolean> man(@RequestBody AdminLoginEntity adminLoginEntity) {
		Boolean response =adminService.findAdmin_loginByUserNameAndPassword(adminLoginEntity.getUserName(),adminLoginEntity.getPassword());
		return ResponseEntity.ok(response);
		
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		
		AuthResponse authResponse =  new AuthResponse();
		try {
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword());
			authenticationManager.authenticate(usernamePasswordAuthenticationToken);
			
		}catch(Exception e) {
			authResponse.setAuthenticated(false);
		
			return ResponseEntity.status(HttpStatus.OK).body(authResponse);
		}
		authResponse.setAccountNumber(ApplicationConstants.ACCOUNT_NUMBER);
		authResponse.setAuthenticated(true);
		authResponse.setToken(jwtUtil.generateToken(authRequest.getUserName()));
		return ResponseEntity.status(HttpStatus.ACCEPTED).body( authResponse);
	}
	
	




}
	
	

