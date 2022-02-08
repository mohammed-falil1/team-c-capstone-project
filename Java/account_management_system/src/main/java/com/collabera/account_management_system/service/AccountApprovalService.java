package com.collabera.account_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.entity.AccountApproval;
import com.collabera.account_management_system.repo.AccountApprovalRepo;
import com.collabera.account_management_system.utility.Generators;

@Service
public class AccountApprovalService {

	@Autowired
	AccountApprovalRepo accountApprovalRepo;

	@Autowired
	AccountApproval accountApproval;

	public void updateStatus(int userId,String status) {
		AccountApproval accountApprovalFromDb = accountApprovalRepo.findAccount_approvalByUserId(userId);
//		accountApproval.setStatus("YES");
//		accountApproval.setTimestamp(Generators.getTimeStamp());
//		accountApproval.setUserId(userId);
		
		accountApprovalFromDb.setStatus(status);
		accountApprovalRepo.save(accountApprovalFromDb);
		
	}

}
