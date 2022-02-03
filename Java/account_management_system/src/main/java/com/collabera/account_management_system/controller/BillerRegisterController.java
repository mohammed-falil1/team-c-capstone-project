package com.collabera.account_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.collabera.account_management_system.service.BillerRegisterService;
import com.collabera.account_management_system.entity.BillerRegister;

@RestController
@RequestMapping("/billerregister")
public class BillerRegisterController{
	
	@Autowired
	BillerRegisterService billerregisterService;

	@GetMapping("/")
	public ResponseEntity<List<BillerRegister>> getBillerRegisterAll()
	{
		List<BillerRegister> billerregisterEntity = billerregisterService.findAllBillerRegisters();
		return ResponseEntity.ok(billerregisterEntity);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BillerRegister> getBillerProviderById(@PathVariable("id") int id)
	{
		BillerRegister billerregisterEntity = billerregisterService.findById(id);
		return ResponseEntity.ok(billerregisterEntity);
	}
	
	@GetMapping("/billerregister/{billername}")
	public ResponseEntity<BillerRegister> getBillerRegisterByBillerName(@PathVariable("billername") String billername)
	{
		BillerRegister billerregisterEntity = billerregisterService.findAllBillerRegistersByBillerName(billername);
		return ResponseEntity.ok(billerregisterEntity);
	}
	
	@PostMapping("/add-billerregister")
	public ResponseEntity<BillerRegister> createbillerRegister (@RequestBody BillerRegister billerRegister){

		billerregisterService.createbillerRegister(billerRegister);
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
}
