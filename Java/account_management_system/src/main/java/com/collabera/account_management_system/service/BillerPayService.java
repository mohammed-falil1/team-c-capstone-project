package com.collabera.account_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.Vo.BillerPayment;
import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.BillerPay;
import com.collabera.account_management_system.entity.BillerRegister;
import com.collabera.account_management_system.entity.BillerStatement;
import com.collabera.account_management_system.repo.BillerPayRepository;
import com.collabera.account_management_system.utility.ApplicationConstants;
import com.collabera.account_management_system.utility.Generators;

@Service
public class BillerPayService {

	@Autowired
	BillerPayRepository billerPayRepository;

	@Autowired
	AccountService accountService;
	
	@Autowired
	BillerStatementService billerStatementService;

	public List<BillerPay> findAllBillerPayers() {
		return billerPayRepository.findAll();
	}

	public BillerPay findById(int id) {
		return billerPayRepository.findBiller_payById(id);
	}

	public BillerPay findAllBillerPayByConsumerNo(int consumerno) {
		return billerPayRepository.findByConsumerNumber(consumerno);
	}

	public BillerPay findAllBillerPayByTimestamp(long timestamp) {
		return billerPayRepository.findByTimestamp(timestamp);
	}

	public BillerPay createbillerPay(BillerPay billerPay) {
		billerPay.setAccountNumber(ApplicationConstants.ACCOUNT_NUMBER);
		billerPay.setTimestamp(Generators.getTimeStamp());
		System.out.println("TimeStamp " + Generators.getTimeStamp());
		billerPay = billerPayRepository.save(billerPay);
		return billerPay;
	}
//
//	public void createbillerProvider(BillerProvider billerProvider) {
//		// TODO Auto-generated method stub
//		
//		billerproviderRepository.save(billerProvider);
//	}

	public String makePayment(BillerPayment billerPayment) {
		String response = accountService.billerPayment(billerPayment);
		return response;
	}

}
