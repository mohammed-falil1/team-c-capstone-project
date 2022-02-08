package com.collabera.account_management_system.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.collabera.account_management_system.entity.AccountApproval;
import com.collabera.account_management_system.service.AccountApprovalService;
import com.collabera.account_management_system.service.AdminService;
import com.collabera.account_management_system.utility.ApplicationConstants;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:3000/")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	AccountApprovalService accountApprovalService;

	private static final Logger logger =  LogManager.getLogger(AdminController.class);

	@GetMapping("/users/{from}/{to}")
	public ResponseEntity<List<AccountApproval>> getUsersFromDate(@PathVariable String from, @PathVariable String to) {
		List<AccountApproval> accountApprovals = adminService.getApprovals(from, to);
		logger.debug("Logger debug");
//		logger.info("Logger info");
//		logger.warn("Logger warn");
//		logger.error("logger error");
		return ResponseEntity.ok(accountApprovals);

	}

	@GetMapping("/account-approval/accepted/{userId}")
	public ResponseEntity<Boolean> accounApproval(@PathVariable int userId) {

		boolean response = adminService.accountApporval(userId);

		return ResponseEntity.ok(response);

	}
	
	@GetMapping("/account-approval/rejected/{userId}")
	public ResponseEntity<Void> rejectAccount(@PathVariable("userId") int userId ){
		accountApprovalService.updateStatus(userId, ApplicationConstants.ADMIN_APPOROVAL_REJECTED);
		return ResponseEntity.ok().build();
		
	}
	
	@GetMapping("/account-approvals/{criteria}")
	public ResponseEntity<List<AccountApproval>> getAccountApprovals(@PathVariable("criteria") String criteria){
		List<AccountApproval> accountApprovalsList =adminService.findAccount_approvalByStatus(criteria);
		return ResponseEntity.ok(accountApprovalsList);
		
	}

	

}
