package com.collabera.account_management_system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.account_management_system.entity.AadharDb;

public interface AadharRepo extends JpaRepository<AadharDb, Integer> {

	Optional<AadharDb> findAadharByUuid(int id);
}
