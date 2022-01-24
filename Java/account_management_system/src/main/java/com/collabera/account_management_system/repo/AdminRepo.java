package com.collabera.account_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.account_management_system.entity.AccountApproval;

public interface AdminRepo extends JpaRepository<AccountApproval, Integer> {

	List<AccountApproval> findByTimestampBetween(String from, String to);

	
	
}
