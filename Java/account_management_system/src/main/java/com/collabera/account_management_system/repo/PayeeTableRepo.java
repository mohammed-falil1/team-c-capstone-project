package com.collabera.account_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.PayeeTable;

@Repository
public interface PayeeTableRepo extends JpaRepository<PayeeTable, Integer> {

	PayeeTable findPayee_tableByPayeeAccountNumber(long payeeAccountNumber);

	List<PayeeTable> findPayee_tableByPayerAccountNumber(long accountNumber);

}
