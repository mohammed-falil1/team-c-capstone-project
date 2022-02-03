package com.collabera.account_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.collabera.account_management_system.entity.BillerStatement;

@Repository
public interface BillerStatementRepository extends JpaRepository<BillerStatement, Integer> {

	List<BillerStatement> findBiller_statementByAccountNumber(long accountNumber);

	

	
}
