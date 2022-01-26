package com.collabera.account_management_system.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.TransactionTable;

@Repository
public interface TransactionRepo  extends JpaRepository<TransactionTable, Integer>{

	List<TransactionTable> findByTimestampBetween(LocalDate localDateFrom, LocalDate localDateTo);

}
