package com.collabera.account_management_system.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferVO {

	private long amount;
	private long payeeAccountNumber;
	private String remarks;
}
