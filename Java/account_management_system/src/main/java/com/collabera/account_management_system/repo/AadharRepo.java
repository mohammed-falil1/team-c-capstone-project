package com.collabera.account_management_system.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.AadharDb;

@Repository
public interface AadharRepo extends JpaRepository<AadharDb, String> {

	Optional<AadharDb> findAadharByUuid(int id);

}
