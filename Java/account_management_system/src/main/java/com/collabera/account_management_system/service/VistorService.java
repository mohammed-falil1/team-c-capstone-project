package com.collabera.account_management_system.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.entity.ApplicationId;
import com.collabera.account_management_system.entity.User;
import com.collabera.account_management_system.repo.ApplicationIdRepo;
import com.collabera.account_management_system.repo.VisitorRepo;
import com.collabera.account_management_system.utility.ApplicationConstants;
import com.collabera.account_management_system.utility.TimestampGenerator;

@Service
public class VistorService {
	
	@Autowired
	VisitorRepo visitorRepo;
	
	@Autowired
	ApplicationIdRepo applicationIdRepo;
	
	@Autowired
	ApplicationId applicationId;
	
	
	@Autowired
	EmailSenderService emailSenderService;
	
	
	public int getApplicationId() {
		
		ApplicationId applicationIdFromDb=applicationIdRepo.findApplication_idById(1);
		if(applicationIdFromDb==null) {
			System.out.println("application id is null");
			applicationId.setApplicationId(1001);
		}else {
			System.out.println("applicationId is not not ");
			System.out.println(applicationIdFromDb.getApplicationId());
			applicationId.setApplicationId(applicationIdFromDb.getApplicationId());
		}
		int app_id=applicationId.getApplicationId();
		applicationId.setApplicationId(app_id+1);
		applicationIdRepo.save(applicationId);
		return app_id;
			
	}

	public String createAccount(User user) {
		
		user.setTimestamp(TimestampGenerator.getTimeStamp());
		user.setApplicationId(getApplicationId());
		String response;
		User result = visitorRepo.save(user);
		
		if(result==null) {
			response="Sorry .Please Try again later";
			return response;
		}
		response="Success. You will receive a mail.";
		emailSenderService.sendEmail(ApplicationConstants.FROM_EMAIL, result.getEmail(), ApplicationConstants.EMAIL_SUBJECT, ApplicationConstants.EMAIL_BODY);
		return response;
	}
	

}
