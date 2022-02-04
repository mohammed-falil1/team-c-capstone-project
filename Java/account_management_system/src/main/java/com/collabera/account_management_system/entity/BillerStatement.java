package com.collabera.account_management_system.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "biller_statement")
public class BillerStatement {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name ="account_number")
	private long accountNumber;
	
	@Column(name = "amount")
	private long amount;
	
	@Column(name = "bill_number")
	private long billNumber;
	
	@Column(name = "biller_service")
	private String billerService;
	
	@Column(name = "timeStamp")
	private LocalDate timeStamp;
}
