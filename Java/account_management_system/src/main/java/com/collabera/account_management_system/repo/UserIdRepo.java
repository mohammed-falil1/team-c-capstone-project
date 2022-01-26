package com.collabera.account_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.collabera.account_management_system.entity.UserId;

public interface UserIdRepo extends JpaRepository<UserId, Integer> {

	
	UserId findUser_idById(int i);
}
