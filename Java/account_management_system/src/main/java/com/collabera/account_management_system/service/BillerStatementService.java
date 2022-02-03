package com.collabera.account_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.entity.BillerStatement;

import com.collabera.account_management_system.repo.BillerStatementRepository;

@Service
public class BillerStatementService {

	@Autowired
	BillerStatementRepository billerStatementRepository;

//	public BillerStatement findById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public BillerStatement findAllBillerProviderByConsumerNo(int billno) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public List<BillerStatement> findAllBillerStatementByAccountNo(long accountNumber) {
		// TODO Auto-generated method stub
		return billerStatementRepository.findBiller_statementByAccountNumber(accountNumber);
	}

	public void addItToBillerStatementTable(BillerStatement billerStatement) {
		billerStatementRepository.save(billerStatement);
		
	}

}
