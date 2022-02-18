package com.collabera.account_management_system.Vo;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BillerPayment {

	private long amount;
	private long accountNumber;
	private long billNumber;
	private String billerService;

}
