package com.collabera.account_management_system.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.AccountApproval;
import com.collabera.account_management_system.entity.TransactionTable;
import com.collabera.account_management_system.repo.TransactionRepo;
import com.collabera.account_management_system.utility.Generators;

@Service
public class TransactionsService {

	@Autowired
	TransactionRepo transactionRepo;


	public void addItToTransactionTable(Account account,String type) {
		TransactionTable transactionTable = new TransactionTable();
		transactionTable.setAmount(account.getAccountNumber());
		transactionTable.setRemarks("initial");
		transactionTable.setTimestamp(Generators.getTimeStamp());
		transactionTable.setTransactionType(type);
		transactionRepo.save(transactionTable);

	}
	
	
	public List<TransactionTable> getTransactions(String from, String to) {

		LocalDate localDateTo = LocalDate.parse(to);
		LocalDate localDateFrom = LocalDate.parse(from);
		return transactionRepo.findByTimestampBetween(localDateFrom, localDateTo);
	}

}
