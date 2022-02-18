package com.collabera.account_management_system.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.collabera.account_management_system.Vo.BillerPayment;
import com.collabera.account_management_system.Vo.DepositOrWithdraw;
import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.BillerRegister;
import com.collabera.account_management_system.entity.BillerStatement;
import com.collabera.account_management_system.repo.AccountRepo;
import com.collabera.account_management_system.repo.BillerRegisterRepo;
import com.collabera.account_management_system.repo.BillerStatementRepo;
import com.collabera.account_management_system.repo.ServiceProviderRepo;
import com.collabera.account_management_system.repo.TransactionRepo;
import com.collabera.account_management_system.utility.ApplicationConstants;
import com.collabera.account_management_system.utility.Generators;

import com.collabera.account_management_system.entity.ServiceProviders;
import com.collabera.account_management_system.entity.TransactionTable;

@SpringBootTest
public class BillerServiceTest {

	@Autowired
	BillerService billerService;

	@MockBean
	BillerRegisterRepo billerRegisterRepo;

	@MockBean
	ServiceProviderRepo serviceProviderRepo;

	@Autowired
	BillerPayment billerPayment;

	@Autowired
	Account account;

	@Autowired
	BillerStatement billerStatement;

	@MockBean
	BillerStatementRepo billerStatementRepo;

	@MockBean
	TransactionRepo transactionRepo;

	@Autowired
	DepositOrWithdraw depositOrWithdraw;

	@Autowired
	TransactionsService transactionsService;
	
	@MockBean
	AccountRepo accountRepo;

	@Test
	public void registerBillerTest() {
		BillerRegister billerRegister = new BillerRegister();
		billerRegister.setAccountNumber(10001L);
		billerRegister.setBillerName("falil");
		billerRegister.setConsumerNumber(10000L);
		billerRegister.setId(1);
		billerRegister.setTimeStamp(Generators.getTimeStamp());

		billerService.registerBiller(billerRegister);
		verify(billerRegisterRepo, times(1)).save(billerRegister);
	}

	@Test
	public void getAllBillersTest() {
		List<ServiceProviders> list = new ArrayList<ServiceProviders>();
		ServiceProviders serviceOne = new ServiceProviders(1, "Airtel");
		ServiceProviders serviceTwo = new ServiceProviders(2, "jio");
		list.add(serviceOne);
		list.add(serviceTwo);
		when(serviceProviderRepo.findAll()).thenReturn(list);
		List<ServiceProviders> billerProviders = billerService.getAllBillers();
		assertEquals(2, billerProviders.size());
		verify(serviceProviderRepo, times(1)).findAll();

	}

	@Test
	public void pay() {
		billerPayment.setAccountNumber(ApplicationConstants.ACCOUNT_NUMBER);
		billerPayment.setAmount(1000L);
		billerPayment.setBillNumber(12345L);
		billerPayment.setBillerService("Airtel");

		account.setId(1);
		account.setAccountNumber(100001L);
		account.setBalance(5000L);
		account.setTimestamp(Generators.getTimeStamp());
		account.setUserId(101);
		
		when(accountRepo.findAccountsByAccountNumber(account.getAccountNumber())).thenReturn(account);

		billerStatement.setAccountNumber(account.getAccountNumber());
		billerStatement.setBillNumber(billerPayment.getBillNumber());
		billerStatement.setTimeStamp(Generators.getTimeStamp());
		billerStatement.setAmount(billerPayment.getAmount());
		billerStatement.setBillerService(billerPayment.getBillerService());

		when(billerStatementRepo.save(billerStatement)).thenReturn(billerStatement);

		depositOrWithdraw.setRemarks(billerPayment.getBillerService() + "Service");
		depositOrWithdraw.setAmount(billerPayment.getAmount());
		depositOrWithdraw.setType(ApplicationConstants.DEBIT);

		transactionsService.addItToTransactionTable(account, depositOrWithdraw);

		TransactionTable transactionTable = new TransactionTable();
		transactionTable.setAccountNumber(account.getAccountNumber());
		transactionTable.setRemarks(depositOrWithdraw.getRemarks());
		transactionTable.setTimestamp(Generators.getTimeStamp());
		transactionTable.setTransactionType(depositOrWithdraw.getType());
		transactionTable.setAmount(depositOrWithdraw.getAmount());

		when(transactionRepo.save(transactionTable)).thenReturn(transactionTable);

		assertEquals(ApplicationConstants.SUCCESS, billerService.pay(billerPayment));

	}

}
