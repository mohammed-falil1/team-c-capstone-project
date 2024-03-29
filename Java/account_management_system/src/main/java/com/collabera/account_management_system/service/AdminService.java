package com.collabera.account_management_system.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.Vo.DepositOrWithdraw;
import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.entity.AccountApproval;
import com.collabera.account_management_system.entity.AccountNumber;
import com.collabera.account_management_system.entity.AdminLoginEntity;
import com.collabera.account_management_system.entity.ApplicationId;
import com.collabera.account_management_system.entity.LoginUser;
import com.collabera.account_management_system.entity.TransactionTable;
import com.collabera.account_management_system.entity.User;
import com.collabera.account_management_system.repo.AccountNumberRepo;
import com.collabera.account_management_system.repo.AccountRepo;
import com.collabera.account_management_system.repo.AdminLoginRepo;
import com.collabera.account_management_system.repo.AdminRepo;
import com.collabera.account_management_system.repo.LoginAuthenticationRepo;
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

//	@Autowired
//	Account account;

	@Autowired
	VisitorService vistorService;

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
	
	@Autowired
	AdminLoginRepo adminLoginRepo;
	
	@Autowired
	LoginAuthenticationRepo loginAuthenticationRepo;

	public List<AccountApproval> getApprovals(String from, String to) {

		LocalDate localDateTo = LocalDate.parse(to);
		LocalDate localDateFrom = LocalDate.parse(from);
		return adminRepo.findByTimestampBetween(localDateFrom, localDateTo);
	}

	public boolean accountApporval(int userId) {
		User user = userRepo.findUsersByUserId(userId);
		DepositOrWithdraw depositOrWithdraw = new DepositOrWithdraw();
		Account account = new Account();

		if (user != null) {
			accountApprovalService.updateStatus(userId,ApplicationConstants.ADMIN_APPROVAL_ACCEPTED);
			userRepo.save(user);
			depositOrWithdraw.setAmount(user.getInitialBalance());
			System.out.println("user initial balance ");
			depositOrWithdraw.setRemarks("Initial");
			depositOrWithdraw.setType(ApplicationConstants.CREDIT);
			account = accountService.addItToAccountTable(user);
			transactionsService.addItToTransactionTable(account,depositOrWithdraw);
			
			LoginUser loginUser = new LoginUser();
			loginUser.setUserName(user.getEmail());
			loginUser.setPassword(String.valueOf(user.getMobileNumber()));
			loginUser.setAccountNumber(account.getAccountNumber());
			loginAuthenticationRepo.save(loginUser);
			
			
			// send email to the user on account opening
//			sendEmailAfterAccountApproval(user);
			return true;
		}
		return false;
	}

	public void sendEmailAfterAccountApproval(User user) {
		String subject = "Account Opened Sucessfully";
		String body = "Account Opened Sucessfully. You can login with your email.";
		emailSenderService.sendEmail(ApplicationConstants.SENDER_EMAIL_ID, user.getEmail(), subject, body);

	}

	public List<AccountApproval> findAccount_approvalByStatus(String criteria) {
		
		return adminRepo.findAccount_approvalByStatus(criteria);
	}

	public Boolean findAdmin_loginByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		AdminLoginEntity response=adminLoginRepo.findAdmin_loginByUserNameAndPassword(userName,password);
		if(response==null) {
			return false;
		}
		return true;
	}
	





}
