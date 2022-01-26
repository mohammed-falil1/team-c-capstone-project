package com.collabera.account_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.AccountApproval;

@Repository
public interface AccountApprovalRepo extends JpaRepository<AccountApproval, Integer> {

	AccountApproval findAccount_approvalByUserId(int userId);

}
