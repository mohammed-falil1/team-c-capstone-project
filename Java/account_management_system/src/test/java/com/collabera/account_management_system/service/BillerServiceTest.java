package com.collabera.account_management_system.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.collabera.account_management_system.entity.BillerRegister;
import com.collabera.account_management_system.repo.BillerRegisterRepo;
import com.collabera.account_management_system.repo.ServiceProviderRepo;
import com.collabera.account_management_system.utility.Generators;

import com.collabera.account_management_system.entity.ServiceProviders;


@SpringBootTest
public class BillerServiceTest {

	@Autowired
	BillerService billerService;

	@MockBean
	BillerRegisterRepo billerRegisterRepo;
	
	@MockBean
	ServiceProviderRepo serviceProviderRepo;
	
	
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
	
	@Test
	public void getAllBillersTest() {
		List<ServiceProviders> list = new ArrayList<ServiceProviders>();
		ServiceProviders serviceOne = new ServiceProviders(1, "Airtel");
		ServiceProviders serviceTwo = new ServiceProviders(2, "jio");
		list.add(serviceOne);
		list.add(serviceTwo);
		when(serviceProviderRepo.findAll()).thenReturn(list);
		List<ServiceProviders> billerProviders = billerService.getAllBillers();
		assertEquals(2, billerProviders.size());
		verify(serviceProviderRepo, times(1)).findAll();
		
	}

}
