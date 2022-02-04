package com.collabera.account_management_system.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.BillerStatement;

@Repository
public interface BillerStatementRepo extends JpaRepository<BillerStatement, Integer> {

	List<BillerStatement> findByAccountNumberAndTimeStampBetween(long accountNumber, LocalDate localDateFrom,
			LocalDate localDateTo);

}
