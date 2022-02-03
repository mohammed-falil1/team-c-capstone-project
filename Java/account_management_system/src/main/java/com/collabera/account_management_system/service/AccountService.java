package com.collabera.account_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.Vo.BillerPayment;
import com.collabera.account_management_system.Vo.DepositOrWithdraw;
import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.BillerStatement;
import com.collabera.account_management_system.entity.User;
import com.collabera.account_management_system.repo.AccountRepo;
import com.collabera.account_management_system.utility.ApplicationConstants;
import com.collabera.account_management_system.utility.Generators;

@Service
public class AccountService {

	@Autowired
	AccountRepo accountRepo;

	@Autowired
	Generators generators;

	@Autowired
	TransactionsService transactionsService;

	@Autowired
	BillerStatementService billerStatementService;

	public Account addItToAccountTable(User user) {
		Account account = new Account();
		account.setAccountNumber(generators.getNewAccountNumber());
		account.setBalance(user.getInitialBalance());
		account.setUserId(user.getUserId());
		account.setTimestamp(Generators.getTimeStamp());
		// add it into the account table
		accountRepo.save(account);
		return account;
	}

	public String depositOrWithdrawService(DepositOrWithdraw depositOrWithdraw) {

		Account account = accountRepo.findAccountsById(ApplicationConstants.ACCOUNT_NUMBER);
		if (depositOrWithdraw.getType().equals(ApplicationConstants.CREDIT)) {

			account.setBalance(account.getBalance() + depositOrWithdraw.getAmount());
			accountRepo.save(account);
			transactionsService.addItToTransactionTable(account, depositOrWithdraw);
			return ApplicationConstants.SUCCESS;
		} else {// Withdraw
			if (account.getBalance() - depositOrWithdraw.getAmount() >= 1000) {
				account.setBalance(account.getBalance() - depositOrWithdraw.getAmount());
				accountRepo.save(account);
				depositOrWithdraw.setType(ApplicationConstants.DEBIT);
				transactionsService.addItToTransactionTable(account, depositOrWithdraw);
				return ApplicationConstants.SUCCESS;
			} else {
				return ApplicationConstants.INSUFFICIENT_BALANCE;
			}
		}

	}
	
	
	public Account getAccountDetail(long accountNumber) {
		Account account = accountRepo.findAccountsByAccountNumber(accountNumber);
		return account;
	}
	

	public String billerPayment(BillerPayment billerPayment) {
		Account account = accountRepo.findAccountsByAccountNumber(ApplicationConstants.ACCOUNT_NUMBER);
		if (account.getBalance() - billerPayment.getAmount() > 1000) {
			account.setBalance(account.getBalance() - billerPayment.getAmount());
			accountRepo.save(account);
			BillerStatement billerStatement = new BillerStatement();
			billerStatement.setAccountNumber(account.getAccountNumber());
			billerStatement.setBillNo(billerPayment.getBillNumber());
			billerStatement.setTimestamp(Generators.getTimeStamp());
			billerStatement.setAmount(billerPayment.getAmount());
			billerStatement.setBillerService(billerPayment.getBillerService());
			billerStatementService.addItToBillerStatementTable(billerStatement);
			DepositOrWithdraw depositOrWithdraw = new DepositOrWithdraw();
			depositOrWithdraw.setRemarks(billerPayment.getBillerService()+"Service");
			depositOrWithdraw.setAmount(billerPayment.getAmount());
			depositOrWithdraw.setType(ApplicationConstants.DEBIT);
			transactionsService.addItToTransactionTable(account,depositOrWithdraw );
			return ApplicationConstants.SUCCESS;
		}

		return ApplicationConstants.INSUFFICIENT_BALANCE;
	}

}
