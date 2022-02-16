package com.collabera.account_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.Account;
import com.collabera.account_management_system.utility.ApplicationConstants;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {


	Account findAccountsByAccountNumber(long accountNummber);

}
