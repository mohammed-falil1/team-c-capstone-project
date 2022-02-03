package com.collabera.account_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.collabera.account_management_system.entity.BillerStatement;
import com.collabera.account_management_system.service.BillerStatementService;

@RestController
@RequestMapping("/billerstatement")
public class BillerStatementController {
	
	@Autowired
	BillerStatementService billerstatementService;
	
//	@GetMapping("/{id}")
//	public ResponseEntity<BillerStatement> getBillerStatementById(@PathVariable("id") int id)
//	{
//		BillerStatement billerstatementEntity = billerstatementService.findById(id);
//		return ResponseEntity.ok(billerstatementEntity);
//	}
//	
//	@GetMapping("/billerstatement/{billno}")
//	public ResponseEntity <BillerStatement> getBillerProviderByBillNo(@PathVariable("billno") int billno)
//	{
//		BillerStatement billerstatementEntity = billerstatementService.findAllBillerProviderByConsumerNo(billno);
//		return ResponseEntity.ok(billerstatementEntity);
//	}
	
	@GetMapping("/billerstatement/{accountno}")
	public ResponseEntity <List<BillerStatement>> getBillerProviderByAccountNo(@PathVariable("accountno") int accountno)
	{
		List<BillerStatement> billerStatementList = billerstatementService.findAllBillerStatementByAccountNo(accountno);
		return ResponseEntity.ok(billerStatementList);
	}
	
//	@GetMapping("/billerstatement/{timestamp}")
//	public ResponseEntity <BillerStatement> getBillerStatementByTimestamp(@PathVariable("timestamp") long timestamp)
//	{
//		BillerStatement billerstatementEntity = billerstatementService.findAllBillerStatementByAccountNo(timestamp);
//		return ResponseEntity.ok(billerstatementEntity);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
