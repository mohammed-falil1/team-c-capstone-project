package com.collabera.account_management_system.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepositOrWithdraw {

	private long amount;
	private String type;
	private String remarks;

}
