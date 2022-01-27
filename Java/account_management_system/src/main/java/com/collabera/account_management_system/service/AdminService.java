package com.collabera.account_management_system.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.omg.IOP.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.AccountApproval;
import com.collabera.account_management_system.entity.AccountNumber;
import com.collabera.account_management_system.entity.ApplicationId;
import com.collabera.account_management_system.entity.TransactionTable;
import com.collabera.account_management_system.entity.User;
import com.collabera.account_management_system.repo.AccountNumberRepo;
import com.collabera.account_management_system.repo.AccountRepo;
import com.collabera.account_management_system.repo.AdminRepo;
import com.collabera.account_management_system.repo.TransactionRepo;
import com.collabera.account_management_system.repo.UserRepo;
import com.collabera.account_management_system.utility.ApplicationConstants;
import com.collabera.account_management_system.utility.Generators;

import net.bytebuddy.description.type.TypeDescription.Generic.Visitor;

@Service
public class AdminService {

	@Autowired
	AdminRepo adminRepo;

	@Autowired
	AccountNumberRepo accountNumberRepo;

	@Autowired
	AccountNumber accountNumber;

	@Autowired
	UserRepo userRepo;

	@Autowired
	Account account;

	@Autowired
	VistorService vistorService;

	@Autowired
	EmailSenderService emailSenderService;

	@Autowired
	TransactionsService transactionsService;

	@Autowired
	Generators generators;

	@Autowired
	AccountService accountService;

	@Autowired
	AccountApprovalService accountApprovalService;

	public List<AccountApproval> getApprovals(String from, String to) {

		LocalDate localDateTo = LocalDate.parse(to);
		LocalDate localDateFrom = LocalDate.parse(from);
		return adminRepo.findByTimestampBetween(localDateFrom, localDateTo);
	}

	public boolean accountApporval(int userId) {
		User user = userRepo.findUsersByUserId(userId);
		if (user != null) {
			System.out.print("inside if cases and userId = " + userId);
			accountApprovalService.updateStatus(userId);
			userRepo.save(user);
			account = accountService.addItToAccountTable(user);
			transactionsService.addItToTransactionTable(account,"credit");

			// send email to the user on account opening
			sendEmailAfterAccountApproval(user);
			return true;
		}
		return false;
	}

	public void sendEmailAfterAccountApproval(User user) {
		String subject = "Account Opened Sucessfully";
		String body = "Account Opened Sucessfully. You can login with your email.";
		emailSenderService.sendEmail(ApplicationConstants.SENDER_EMAIL_ID, user.getEmail(), subject, body);

	}


//	public boolean checkUser(int userId) {
//
//		User user = visitorRepo.findUsersByUserId(userId);
//
//		if (user == null) {
//			
//			createNewAccount(userId);
//			return false;
//		} else {
//			
//			
//			return true;
//		}
//
//	}

}
