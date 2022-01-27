package com.collabera.account_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.BillerProvider;




@Repository
public interface BillerProviderRepository extends JpaRepository<BillerProvider, Integer> {

	BillerProvider findBiller_providerById(int id);
	
	
	BillerProvider findByConsumerNumber(int consumeno);
	  
	BillerProvider findByTimestamp(long timestamp);

	

	
	
}