package com.collabera.account_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.account_management_system.entity.SericeProviders;
import com.collabera.account_management_system.service.BillerService;

@Repository
public interface ServiceProviderRepo extends JpaRepository<SericeProviders, Integer>{

}
