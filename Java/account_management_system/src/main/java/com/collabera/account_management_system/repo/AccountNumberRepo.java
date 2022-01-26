package com.collabera.account_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.account_management_system.entity.AccountNumber;
import com.collabera.account_management_system.entity.ApplicationId;

public interface AccountNumberRepo extends JpaRepository<AccountNumber, Integer> {

	AccountNumber findAccount_numberById(int i);

}
