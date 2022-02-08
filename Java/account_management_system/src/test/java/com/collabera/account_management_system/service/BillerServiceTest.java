package com.collabera.account_management_system.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.collabera.account_management_system.entity.BillerRegister;
import com.collabera.account_management_system.repo.BillerRegisterRepo;
import com.collabera.account_management_system.utility.Generators;

@SpringBootTest
public class BillerServiceTest {

	@Autowired
	BillerService billerService;

	@MockBean
	BillerRegisterRepo billerRegisterRepo;
	
	
	@Test
	public void registerBillerTest() {
		BillerRegister billerRegister = new BillerRegister();
		billerRegister.setAccountNumber(10001L);
		billerRegister.setBillerName("falil");
		billerRegister.setConsumerNumber(10000L);
		billerRegister.setId(1);
		billerRegister.setTimeStamp(Generators.getTimeStamp());
		
		billerService.registerBiller(billerRegister);
		verify(billerRegisterRepo,times(1)).save(billerRegister);
	}

}
