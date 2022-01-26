package com.collabera.account_management_system.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.entity.AccountApproval;
import com.collabera.account_management_system.entity.ApplicationId;
import com.collabera.account_management_system.entity.PanCardDb;
import com.collabera.account_management_system.entity.User;
import com.collabera.account_management_system.entity.UserId;
import com.collabera.account_management_system.repo.ApplicationIdRepo;
import com.collabera.account_management_system.repo.UserIdRepo;
import com.collabera.account_management_system.repo.UserRepo;
import com.collabera.account_management_system.utility.ApplicationConstants;
import com.collabera.account_management_system.utility.Generators;

@Service
public class VistorService {

	@Autowired
	UserRepo userRepo;

	@Autowired
	ApplicationIdRepo applicationIdRepo;

	@Autowired
	PanCardDb panCardDb;

	@Autowired
	ApplicationId applicationId;

	@Autowired
	EmailSenderService emailSenderService;

	@Autowired
	UserIdRepo userIdRepo;

	@Autowired
	UserId userId;

	@Autowired
	Generators generators;

	public AccountApproval addingChild(int userId) {

		AccountApproval accountApproval1 = new AccountApproval();
		accountApproval1.setStatus("No");
		accountApproval1.setTimestamp(Generators.getTimeStamp());
		accountApproval1.setUserId(userId);

		return accountApproval1;
	}

	public String createAccount(User user) {

		user.setApplicationId(generators.getApplicationId());
		user.setTimestamp(Generators.getTimeStamp());
		user.setUserId(generators.getUserId());
//		Set<AccountApproval> createdSet = addingChild(user);
//		user.setAccountApproval(createdSet)
		AccountApproval accountApproval = addingChild(user.getUserId());
		user.setAccountApproval(accountApproval);
		String response;
		User result = userRepo.save(user);

		if (result == null) {
			response = "Sorry .Please Try again later";
			return response;
		}

		response = "Success. You will receive a mail.";
		emailSenderService.sendEmail(ApplicationConstants.SENDER_EMAIL_ID, result.getEmail(),
				ApplicationConstants.EMAIL_SUBJECT_NEW_ACCOUNT, ApplicationConstants.EMAIL_BODY_NEW_ACCOUNT);
		return response;
	}

	public long getIntilaBalance(int userId) {

		User user = userRepo.findUsersByUserId(userId);

		return user.getInitialBalance();
	}

}
