package com.collabera.account_management_system.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.AccountApproval;

@Repository
public interface AdminRepo extends JpaRepository<AccountApproval, Integer> {

	List<AccountApproval> findByTimestampBetween(LocalDate localDateFrom, LocalDate localDateTo);

	List<AccountApproval> findAccount_approvalByStatus(String criteria);

	

}
