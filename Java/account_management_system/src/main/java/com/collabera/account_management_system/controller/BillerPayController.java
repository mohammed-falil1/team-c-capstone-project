package com.collabera.account_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.account_management_system.Vo.BillerPayment;
import com.collabera.account_management_system.entity.BillerPay;
import com.collabera.account_management_system.entity.BillerRegister;
import com.collabera.account_management_system.service.BillerPayService;

@RestController
@RequestMapping("/billerpay")
@CrossOrigin(origins = "http://localhost:3000/")
public class BillerPayController {

	@Autowired
	BillerPayService billerPayService;

	@Autowired
	BillerPay billerPay;

	@GetMapping("/")
	public ResponseEntity<List<BillerPay>> getBillerPayAll() {
		List<BillerPay> billerPayEntity = billerPayService.findAllBillerPayers();
		return ResponseEntity.ok(billerPayEntity);
	}

	@GetMapping("/{id}")
	public ResponseEntity<BillerPay> getBillerPayById(@PathVariable("id") int id) {
		BillerPay billerPayEntity = billerPayService.findById(id);
		return ResponseEntity.ok(billerPayEntity);
	}

	@GetMapping("/billerprovider/{consumerno}")
	public ResponseEntity<BillerPay> getBillerPayByConsumerNo(@PathVariable("consumerno") int consumerno) {
		BillerPay billerproviderEntity = billerPayService.findAllBillerPayByConsumerNo(consumerno);
		return ResponseEntity.ok(billerproviderEntity);
	}

	@GetMapping("/billerprovider/{timestamp}")
	public ResponseEntity<BillerPay> getBillerProviderByTimestamp(@PathVariable("timestamp") long timestamp) {
		BillerPay billerPayEntity = billerPayService.findAllBillerPayByTimestamp(timestamp);
		return ResponseEntity.ok(billerPayEntity);
	}

//	@GetMapping("/add/{billerName}/{consumerNo}")
//	public ResponseEntity<BillerRegister> addNewBillerProvider(@PathVariable("billerName") String billername,@PathVariable int   consumerNo)
//	{
//		BillerRegister billerregisterEntity = billerproviderService.createBillerProvider(billername,consumerNo);
//		return ResponseEntity.ok(billerregisterEntity);
//	}

	@PostMapping("/add-biller-service")
	public ResponseEntity<BillerPay> createbillerPay(@RequestBody BillerPay billerPay) {
		billerPay = billerPayService.createbillerPay(billerPay);
		return ResponseEntity.status(HttpStatus.CREATED).build();

	}

	@PostMapping("/pay-biller")
	public ResponseEntity<String> billerPay(@RequestBody BillerPayment billerPayment) {
		String response = billerPayService.makePayment(billerPayment);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

}
