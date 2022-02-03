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

import com.collabera.account_management_system.Vo.DepositOrWithdraw;
import com.collabera.account_management_system.entity.TransactionTable;
import com.collabera.account_management_system.service.AccountService;
import com.collabera.account_management_system.service.TransactionsService;
import com.collabera.account_management_system.utility.ApplicationConstants;


@RestController
@RequestMapping("/acc")
@CrossOrigin(origins = "http://localhost:3000/")
public class AccountController {

	@Autowired
	TransactionsService transactionService;
	
	@Autowired
	AccountService accountService;

	@GetMapping("/stmts/{from}/{to}")
	public ResponseEntity<List<TransactionTable>> getStatement(@PathVariable String from, @PathVariable String to) {

		List<TransactionTable> response = transactionService.getTransactions(from, to);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	@PostMapping("/depost-or-withdraw")
	public ResponseEntity<String> depositOrWithdrawAmount(@RequestBody DepositOrWithdraw depositOrWithdraw) {
		ApplicationConstants.ACCOUNT_NUMBER=1;
		String response = accountService.depositOrWithdrawService(depositOrWithdraw);
		return ResponseEntity.ok(response);

		
	}
	
	
	
	
	

}
