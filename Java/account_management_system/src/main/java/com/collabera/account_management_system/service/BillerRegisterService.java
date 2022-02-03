package com.collabera.account_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.collabera.account_management_system.entity.BillerRegister;
import com.collabera.account_management_system.repo.BillerRegisterRepository;


@Service
public class BillerRegisterService {
	
	@Autowired
	BillerRegisterRepository billerregisterRepository;

	public List<BillerRegister> findAllBillerRegisters() {
		return billerregisterRepository.findAll();
	}
	

	public BillerRegister findById(int id) {
		return billerregisterRepository.findBiller_registerById(id);
	}


	public BillerRegister findAllBillerRegistersByBillerName(String billername) {
		return billerregisterRepository.findBiller_registerByBillerName(billername);
	}


	public void createbillerRegister(BillerRegister billerRegister) {
		// TODO Auto-generated method stub
		billerregisterRepository.save(billerRegister);
	}

	
}
