package com.collabera.account_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.account_management_system.entity.TransactionTable;
import com.collabera.account_management_system.service.TransactionsService;


@RestController
@RequestMapping("/acc")
@CrossOrigin(origins = "http://localhost:3000/")
public class AccountController {

	@Autowired
	TransactionsService transactionService;

	@GetMapping("/stmts/{from}/{to}")
	public ResponseEntity<List<TransactionTable>> getStatement(@PathVariable String from, @PathVariable String to) {

		List<TransactionTable> response = transactionService.getTransactions(from, to);

		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	

}
