package com.collabera.account_management_system.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.Vo.BillerPayment;
import com.collabera.account_management_system.Vo.DepositOrWithdraw;
import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.BillerRegister;
import com.collabera.account_management_system.entity.ServiceProviders;
import com.collabera.account_management_system.entity.BillerStatement;
import com.collabera.account_management_system.repo.AccountNumberRepo;
import com.collabera.account_management_system.repo.BillerRegisterRepo;
import com.collabera.account_management_system.repo.ServiceProviderRepo;
import com.collabera.account_management_system.repo.BillerStatementRepo;
import com.collabera.account_management_system.utility.ApplicationConstants;
import com.collabera.account_management_system.utility.Generators;

@Service
public class BillerService {

	@Autowired
	BillerRegisterRepo billerRegisterRepo;
	
	
	@Autowired
	AccountService accountService;

	@Autowired
	BillerStatementRepo billerStatementRepo;

	@Autowired
	TransactionsService transactionsService;

	@Autowired
	ServiceProviderRepo serviceProviderRepo;

	public void registerBiller(BillerRegister billerRegister) {

		billerRegister.setAccountNumber(ApplicationConstants.ACCOUNT_NUMBER);
		billerRegister.setTimeStamp(Generators.getTimeStamp());
		billerRegisterRepo.save(billerRegister);
	}

	public String pay(BillerPayment billerPayment) {
		Account account = accountService.getAccountInfo(billerPayment.getAccountNumber());
		if (account.getBalance() - billerPayment.getAmount() > 1000) {
			account.setBalance(account.getBalance() - billerPayment.getAmount());
			accountService.saveItInAccountRepo(account);
			BillerStatement billerStatement = new BillerStatement();
			billerStatement.setAccountNumber(account.getAccountNumber());
			billerStatement.setBillNumber(billerPayment.getBillNumber());
			billerStatement.setTimeStamp(Generators.getTimeStamp());
			billerStatement.setAmount(billerPayment.getAmount());
			billerStatement.setBillerService(billerPayment.getBillerService());
			billerStatementRepo.save(billerStatement);
			DepositOrWithdraw depositOrWithdraw = new DepositOrWithdraw();
			depositOrWithdraw.setRemarks(billerPayment.getBillerService() + "Service");
			depositOrWithdraw.setAmount(billerPayment.getAmount());
			depositOrWithdraw.setType(ApplicationConstants.DEBIT);
			transactionsService.addItToTransactionTable(account, depositOrWithdraw);
			return ApplicationConstants.SUCCESS;
		}

		return ApplicationConstants.INSUFFICIENT_BALANCE;

	}

	public List<BillerStatement> getTransactions(long accountNumber, String from, String to) {

		LocalDate localDateTo = LocalDate.parse(to);
		LocalDate localDateFrom = LocalDate.parse(from);

		return billerStatementRepo.findByAccountNumberAndTimeStampBetween(accountNumber, localDateFrom, localDateTo);

	}

	public List<ServiceProviders> getAllBillers() {

		return serviceProviderRepo.findAll();
	}

	public List<BillerRegister> getBillersOf(long accountNumber) {
		return billerRegisterRepo.findBiller_registeredByAccountNumber(accountNumber);

	}

}
