package com.collabera.account_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.Vo.BillerPayment;
import com.collabera.account_management_system.Vo.ChangePasswordVO;
import com.collabera.account_management_system.Vo.DepositOrWithdraw;
import com.collabera.account_management_system.Vo.TransferVO;
import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.BillerStatement;
import com.collabera.account_management_system.entity.LoginUser;
import com.collabera.account_management_system.entity.PayeeTable;
import com.collabera.account_management_system.entity.User;
import com.collabera.account_management_system.repo.AccountNumberRepo;
import com.collabera.account_management_system.repo.AccountRepo;
import com.collabera.account_management_system.repo.LoginAuthenticationRepo;
import com.collabera.account_management_system.repo.PayeeTableRepo;
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
	PayeeTableRepo payeeTableRepo;
	
	@Autowired
	LoginAuthenticationRepo loginAuthenticationRepo;



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
		Account account = getAccountInfo(ApplicationConstants.ACCOUNT_NUMBER);
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

	public Account getAccountInfo(long accountNumber) {
		System.out.println(accountNumber);
		Account account = accountRepo.findAccountsByAccountNumber(accountNumber);
		return account;
	}

	public void saveItInAccountRepo(Account account) {
		accountRepo.save(account);
	}

	public boolean addPayee(PayeeTable payeeTable) {
		Account account = accountRepo.findAccountsByAccountNumber(payeeTable.getPayeeAccountNumber());
		if (account != null) {
			payeeTable.setPayerAccountNumber(ApplicationConstants.ACCOUNT_NUMBER);
			payeeTable.setTimestamp(Generators.getTimeStamp());
			payeeTableRepo.save(payeeTable);
			return true;
		}
		return false;
	}

	public List<PayeeTable> getPayeeList(long accountNumber) {
		// TODO Auto-generated method stub
		return payeeTableRepo.findPayee_tableByPayerAccountNumber(accountNumber);
	}

	public boolean transfer(TransferVO transferVO) {
		// TODO Auto-generated method stub
		Account accountPayer = getAccountInfo(ApplicationConstants.ACCOUNT_NUMBER);
		Account accountPayee = getAccountInfo(transferVO.getPayeeAccountNumber());
		if (accountPayer != null && accountPayee != null) {
			if (accountPayer.getBalance() - transferVO.getAmount() > 1000) {
				accountPayer.setBalance(accountPayer.getBalance() - transferVO.getAmount());
				accountRepo.save(accountPayer);
				DepositOrWithdraw depositOrWithdraw = new DepositOrWithdraw();
				depositOrWithdraw.setAmount(transferVO.getAmount());
				depositOrWithdraw.setRemarks(transferVO.getRemarks());
				depositOrWithdraw.setType(ApplicationConstants.DEBIT);
				transactionsService.addItToTransactionTable(accountPayer, depositOrWithdraw);

				accountPayee.setBalance(transferVO.getAmount());
				accountRepo.save(accountPayee);
				DepositOrWithdraw depositOrWithdraw2 = new DepositOrWithdraw();
				depositOrWithdraw2.setAmount(transferVO.getAmount());
				depositOrWithdraw2.setRemarks(transferVO.getRemarks());
				depositOrWithdraw2.setType(ApplicationConstants.CREDIT);
				transactionsService.addItToTransactionTable(accountPayee, depositOrWithdraw2);
				return true;
			}
		}

		return false;

	}

	public boolean changePassword(ChangePasswordVO changePasswordVO) {
		LoginUser loginUser = loginAuthenticationRepo.findLoginByAccountNumber(changePasswordVO.getAccountNumber());
		if(loginUser!=null && loginUser.getPassword().equals(changePasswordVO.getOldPassword())){
		loginUser.setPassword(changePasswordVO.getNewPassword());
		loginAuthenticationRepo.save(loginUser);
		return true;
		}
		return false;
	}
	
	

}
