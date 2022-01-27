package com.collabera.account_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.account_management_system.entity.BillerProvider;
import com.collabera.account_management_system.entity.BillerRegister;
import com.collabera.account_management_system.service.BillerProviderService;

@RestController
@RequestMapping("/billerprovider")
@CrossOrigin(origins = "http://localhost:3000/")
public class BillerProviderController {
	
	@Autowired
	BillerProviderService billerproviderService;
	
	@GetMapping("/")
	public ResponseEntity<List<BillerProvider>> getBillerProviderAll()
	{
		List<BillerProvider> billerproviderEntity = billerproviderService.findAllBillerProviders();
		return ResponseEntity.ok(billerproviderEntity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BillerProvider> getBillerProviderById(@PathVariable("id") int id)
	{
		BillerProvider billerproviderEntity = billerproviderService.findById(id);
		return ResponseEntity.ok(billerproviderEntity);
	}
	
	
	@GetMapping("/billerprovider/{consumerno}")
	public ResponseEntity <BillerProvider> getBillerProviderByConsumerNo(@PathVariable("consumerno") int consumerno)
	{
		BillerProvider billerproviderEntity = billerproviderService.findAllBillerProvidersByConsumerNo(consumerno);
		return ResponseEntity.ok(billerproviderEntity);
	}
	
	@GetMapping("/billerprovider/{timestamp}")
	public ResponseEntity <BillerProvider> getBillerProviderByTimestamp(@PathVariable("timestamp") long timestamp)
	{
		BillerProvider billerproviderEntity = billerproviderService.findAllBillerProvidersByTimestamp(timestamp);
		return ResponseEntity.ok(billerproviderEntity);
	}
	
	@GetMapping("/add/{billerName}/{consumerNo}")
	public ResponseEntity<BillerRegister> addNewBillerProvider(@PathVariable("billerName") String billername,@PathVariable int   consumerNo)
	{
		BillerRegister billerregisterEntity = billerproviderService.createBillerProvider(billername,consumerNo);
		return ResponseEntity.ok(billerregisterEntity);
	}
	
}
