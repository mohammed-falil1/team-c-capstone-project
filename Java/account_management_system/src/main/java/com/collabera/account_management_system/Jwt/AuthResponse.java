package com.collabera.account_management_system.Jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	
	private String token;
	private long accountNumber;
	private boolean authenticated;

}
