package com.collabera.account_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.account_management_system.entity.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {

}
