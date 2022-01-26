package com.collabera.account_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.collabera.account_management_system.entity.AccountApproval;
import com.collabera.account_management_system.service.AdminService;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/users/{from}/{to}")
	public ResponseEntity<List<AccountApproval>> getUsersFromDate(@PathVariable String from, @PathVariable String to) {

		List<AccountApproval> accountApprovals = adminService.getApprovals(from, to);

		return ResponseEntity.ok(accountApprovals);

	}

	@GetMapping("/account-approval/{userId}")
	public ResponseEntity<Boolean> accounApproval(@PathVariable int userId) {

		boolean response = adminService.accountAporval(userId);

		return ResponseEntity.ok(response);

	}

}
