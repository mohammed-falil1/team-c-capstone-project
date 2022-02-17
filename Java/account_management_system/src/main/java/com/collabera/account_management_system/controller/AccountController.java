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
import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.PayeeTable;
import com.collabera.account_management_system.entity.TransactionTable;
import com.collabera.account_management_system.service.AccountService;
import com.collabera.account_management_system.service.TransactionsService;
import com.collabera.account_management_system.utility.ApplicationConstants;
import com.collabera.account_management_system.Vo.TransferVO;


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

		List<TransactionTable> response = transactionService.getTransactions(ApplicationConstants.ACCOUNT_NUMBER , from, to);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	@PostMapping("/depost-or-withdraw")
	public ResponseEntity<String> depositOrWithdrawAmount(@RequestBody DepositOrWithdraw depositOrWithdraw) {
		String response = accountService.depositOrWithdrawService(depositOrWithdraw);
		return ResponseEntity.ok(response);

		
	}
	
	@PostMapping("/add-payee")
	public ResponseEntity<Boolean>addPayee(@RequestBody PayeeTable payeeTable){
		boolean response=accountService.addPayee(payeeTable);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/get-payees")
	public ResponseEntity<List<PayeeTable>> getPayeeList(){
		List<PayeeTable> payeeList=accountService.getPayeeList(ApplicationConstants.ACCOUNT_NUMBER);
		return ResponseEntity.ok(payeeList);
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<Boolean> transfer(@RequestBody TransferVO transferVO){
		boolean response = accountService.transfer(transferVO);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/get-balance/{acct-no}")
	public ResponseEntity<Long> getBalance(@PathVariable("acct-no") long accountNumber){
		Account account = accountService.getAccountInfo(accountNumber);
		return ResponseEntity.ok(account.getBalance());
		
	}
	
	
	

}
