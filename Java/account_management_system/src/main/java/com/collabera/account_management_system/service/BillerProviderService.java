package com.collabera.account_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.account_management_system.entity.BillerProvider;
import com.collabera.account_management_system.entity.BillerRegister;
import com.collabera.account_management_system.repo.BillerProviderRepository;
import com.collabera.account_management_system.utility.Generators;


@Service
public class BillerProviderService {
	
	@Autowired
	BillerProviderRepository billerproviderRepository;

	public List<BillerProvider> findAllBillerProviders() {
		return billerproviderRepository.findAll();
	}
	
	public BillerProvider findById(int id) {
		return billerproviderRepository.findBiller_providerById(id);
	}
	

	
	public BillerProvider findAllBillerProvidersByConsumerNo(int consumerno) {
		return billerproviderRepository.findByConsumerNumber(consumerno);
	}

	public BillerProvider findAllBillerProvidersByTimestamp(long timestamp) {
		return billerproviderRepository.findByTimestamp(timestamp);
	}

	public BillerRegister createBillerProvider(String billername, int consumerNo) {
		BillerProvider billerProvider = new BillerProvider();
		billerProvider.setAccountId(Long.valueOf(1));
		billerProvider.setBillerName(billername);
		billerProvider.setConsumerNumber(consumerNo);
		billerProvider.setTimestamp(Generators.getTimeStamp());
		billerproviderRepository.save(billerProvider);
		return null;
	}
	
}
