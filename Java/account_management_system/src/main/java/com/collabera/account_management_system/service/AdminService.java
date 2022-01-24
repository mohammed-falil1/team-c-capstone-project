package com.collabera.account_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.entity.AccountApproval;
import com.collabera.account_management_system.repo.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	AdminRepo adminRepo;

	public List<AccountApproval> getApprovals(String from, String to) {
		return adminRepo.findByTimestampBetween(from,to);
	}
	

	
	
	
}
