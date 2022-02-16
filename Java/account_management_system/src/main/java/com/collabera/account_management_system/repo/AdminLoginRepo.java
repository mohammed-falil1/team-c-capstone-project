package com.collabera.account_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.AdminLoginEntity;

@Repository
public interface AdminLoginRepo extends JpaRepository<AdminLoginEntity, Integer> {

	AdminLoginEntity findAdmin_loginByUserNameAndPassword(String userName, String password);

}
