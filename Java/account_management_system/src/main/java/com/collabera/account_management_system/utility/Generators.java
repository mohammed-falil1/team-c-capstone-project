package com.collabera.account_management_system.utility;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.collabera.account_management_system.entity.AccountNumber;
import com.collabera.account_management_system.entity.ApplicationId;
import com.collabera.account_management_system.entity.UserId;
import com.collabera.account_management_system.repo.AccountNumberRepo;
import com.collabera.account_management_system.repo.ApplicationIdRepo;
import com.collabera.account_management_system.repo.UserIdRepo;

@Component
public class Generators {

	@Autowired
	AccountNumberRepo accountNumberRepo;

	@Autowired
	AccountNumber accountNumber;

	@Autowired
	ApplicationId applicationId;

	@Autowired
	ApplicationIdRepo applicationIdRepo;

	@Autowired
	UserIdRepo userIdRepo;

	@Autowired
	UserId userId;

	static LocalDate localDate;

	public static LocalDate getTimeStamp() {

		localDate = LocalDate.now();
		return localDate;

	}

	public long getAccountNumber() {

		AccountNumber accountNumberFromDB = accountNumberRepo.findAccount_numberById(1);
		if (accountNumberFromDB == null) {
			System.out.println("accountNumber id is null");
			accountNumber.setAccountNumber(Long.valueOf(100001));
		} else {
			System.out.println("accountNUmber is not null ");
			System.out.println(accountNumberFromDB.getAccountNumber());
			accountNumber.setAccountNumber(accountNumberFromDB.getAccountNumber());
		}
		long account_number = accountNumber.getAccountNumber();
		accountNumber.setAccountNumber(account_number + Long.valueOf(1));
		accountNumberRepo.save(accountNumber);
		return account_number;

	}

	public int getApplicationId() {

		ApplicationId applicationIdFromDb = applicationIdRepo.findApplication_idById(1);
		if (applicationIdFromDb == null) {
			System.out.println("application id is null");
			applicationId.setApplicationId(1001);
		} else {
			System.out.println("applicationId is not not ");
			System.out.println(applicationIdFromDb.getApplicationId());
			applicationId.setApplicationId(applicationIdFromDb.getApplicationId());
		}
		int app_id = applicationId.getApplicationId();
		applicationId.setApplicationId(app_id + 1);
		applicationIdRepo.save(applicationId);
		return app_id;

	}

	public int getUserId() {

		 UserId userIdFromDb = userIdRepo.findUser_idById(1);
		if (userIdFromDb == null) {
			System.out.println("user id is null");
			userId.setUserId(101);
		} else {
			System.out.println("user is not null");
			System.out.println(userIdFromDb.getUserId());
			userId.setId(userIdFromDb.getId());
			userId.setUserId(userIdFromDb.getUserId());
		}
		int user_id = userId.getUserId();
		userId.setUserId(user_id + 1);
		userIdRepo.save(userId);
		return user_id;

	}

}
