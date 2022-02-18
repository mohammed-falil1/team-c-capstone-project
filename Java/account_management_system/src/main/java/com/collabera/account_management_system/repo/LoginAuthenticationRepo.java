package com.collabera.account_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.LoginUser;

@Repository
public interface LoginAuthenticationRepo extends JpaRepository<LoginUser, Integer> {

	LoginUser findLoginByUserName(String userName);

	LoginUser findLoginByAccountNumber(long accountNumber);
	

}
