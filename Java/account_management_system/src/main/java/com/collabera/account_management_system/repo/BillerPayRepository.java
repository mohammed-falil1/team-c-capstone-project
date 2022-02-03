package com.collabera.account_management_system.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.BillerPay;

@Repository
public interface BillerPayRepository extends JpaRepository<BillerPay, Integer> {

	BillerPay findBiller_payById(int id);

	BillerPay findByConsumerNumber(int consumeno);

	BillerPay findByTimestamp(long timestamp);

}