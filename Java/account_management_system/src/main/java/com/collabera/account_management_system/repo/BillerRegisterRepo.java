package com.collabera.account_management_system.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.BillerRegister;

@Repository
public interface BillerRegisterRepo extends JpaRepository<BillerRegister, Integer> {

	List<BillerRegister> findBiller_registeredByAccountNumber(long accountNumber);

	
	
	

}
