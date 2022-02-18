package com.collabera.account_management_system.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordVO {
	
	private long accountNumber;
	private String oldPassword;
	private String newPassword;

}
