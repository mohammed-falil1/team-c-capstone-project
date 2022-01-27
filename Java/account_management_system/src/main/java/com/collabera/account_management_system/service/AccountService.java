package com.collabera.account_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.User;
import com.collabera.account_management_system.repo.AccountRepo;
import com.collabera.account_management_system.utility.Generators;

@Service
public class AccountService {

	@Autowired
	AccountRepo accountRepo;

	@Autowired
	Generators generators;

	public Account addItToAccountTable(User user) {
		Account account = new Account();
		account.setAccountNumber(1);
		account.setBalance(user.getInitialBalance());
		account.setUserId(user.getUserId());
		account.setTimestamp(Generators.getTimeStamp());
		// add it into the account table
		return accountRepo.save(account);
	}

}
