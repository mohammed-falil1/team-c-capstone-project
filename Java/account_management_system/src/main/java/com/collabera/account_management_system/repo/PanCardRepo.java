package com.collabera.account_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.PanCardDb;

@Repository
public interface PanCardRepo  extends JpaRepository<PanCardDb, String>{
	
	

}
