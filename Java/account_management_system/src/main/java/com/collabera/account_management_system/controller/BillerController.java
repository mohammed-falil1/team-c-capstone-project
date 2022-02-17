package com.collabera.account_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.account_management_system.Vo.BillerPayment;
import com.collabera.account_management_system.entity.BillerRegister;
import com.collabera.account_management_system.entity.BillerStatement;
import com.collabera.account_management_system.entity.ServiceProviders;
import com.collabera.account_management_system.service.BillerService;
import com.collabera.account_management_system.utility.ApplicationConstants;

@RestController
@RequestMapping("/biller")
public class BillerController {

	@Autowired
	BillerService billerService;

	@GetMapping("/get-services")
	public ResponseEntity<List<ServiceProviders>> getAllBillers() {
		List<ServiceProviders> billerRegisterList =billerService.getAllBillers();
		return ResponseEntity.ok(billerRegisterList);
		
	}

	@PostMapping("/biller-register")
	public ResponseEntity<Void> addBiller(@RequestBody BillerRegister billerRegister) {
		billerService.registerBiller(billerRegister);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PostMapping("/biller-pay")
	public ResponseEntity<String> payBiller(@RequestBody BillerPayment billerPayment) {
		billerPayment.setAccountNumber(ApplicationConstants.ACCOUNT_NUMBER);
		String response = billerService.pay(billerPayment);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/mybillers/{accountnumber}")
	public ResponseEntity<List<BillerRegister>> myBillers(@PathVariable("accountnumber") long accountNumber){
		List<BillerRegister> billerRegisterList=  billerService.getBillersOf(accountNumber);
		return ResponseEntity.ok(billerRegisterList);
	}
	

	@GetMapping("/biller-stmt/{from}/{to}")
	public ResponseEntity<List<BillerStatement>> getStatement(@PathVariable("from") String from,
			@PathVariable("to") String to) {
		List<BillerStatement> billerStatementList = billerService.getTransactions(ApplicationConstants.ACCOUNT_NUMBER,
				from, to);
		return ResponseEntity.ok(billerStatementList);
	}
}
