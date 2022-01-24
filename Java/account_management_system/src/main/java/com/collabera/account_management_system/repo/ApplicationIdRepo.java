package com.collabera.account_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.ApplicationId;

@Repository
public interface ApplicationIdRepo extends JpaRepository<ApplicationId, Integer> {

	ApplicationId findApplication_idById(int i);

}
