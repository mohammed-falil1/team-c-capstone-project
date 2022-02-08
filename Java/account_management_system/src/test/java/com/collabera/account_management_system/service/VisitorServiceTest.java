package com.collabera.account_management_system.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.collabera.account_management_system.entity.AccountApproval;
import com.collabera.account_management_system.entity.User;
import com.collabera.account_management_system.repo.UserRepo;
import com.collabera.account_management_system.utility.ApplicationConstants;
import com.collabera.account_management_system.utility.Generators;

@SpringBootTest
public class VisitorServiceTest {

	@Autowired
	private VisitorService visitorService;
	
	
	@MockBean
	private UserRepo userRepo;
	
	@Test
	public void createAccountTest() {
		User user = new User();
		user.setApplicationId(Long.valueOf(1001));
		user.setTimestamp(Generators.getTimeStamp());
		user.setUserId(101);
		AccountApproval accountApproval = new AccountApproval();
		accountApproval.setStatus(ApplicationConstants.ADMIN_APPROVAL_REQUESTED);
		accountApproval.setTimestamp(Generators.getTimeStamp());
		accountApproval.setUserId(user.getUserId());
		user.setAccountApproval(accountApproval);		
		when(userRepo.save(user)).thenReturn(user);
		String response="Success. You will receive a mail.";
		assertEquals(response, visitorService.createAccount(user));
	}
	
	
	
	
}
