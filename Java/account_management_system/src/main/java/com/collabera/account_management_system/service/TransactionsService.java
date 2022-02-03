package com.collabera.account_management_system.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.Vo.DepositOrWithdraw;
import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.AccountApproval;
import com.collabera.account_management_system.entity.TransactionTable;
import com.collabera.account_management_system.repo.TransactionRepo;
import com.collabera.account_management_system.utility.Generators;

@Service
public class TransactionsService {

	@Autowired
	TransactionRepo transactionRepo;


	public void addItToTransactionTable(Account account,DepositOrWithdraw depositOrWithdraw) {
		TransactionTable transactionTable = new TransactionTable();
		transactionTable.setAccountNumber(account.getAccountNumber());
		transactionTable.setRemarks(depositOrWithdraw.getRemarks());
		transactionTable.setTimestamp(Generators.getTimeStamp());
		transactionTable.setTransactionType(depositOrWithdraw.getType());
		transactionTable.setAmount(depositOrWithdraw.getAmount());
		System.out.println("account Number "+account.getAccountNumber());
		System.out.println("account balance "+account.getBalance());
		transactionRepo.save(transactionTable);

	}
	
	
	
	
	public List<TransactionTable> getTransactions(String from, String to) {

		LocalDate localDateTo = LocalDate.parse(to);
		LocalDate localDateFrom = LocalDate.parse(from);
		return transactionRepo.findByTimestampBetween(localDateFrom, localDateTo);
	}


	

}
