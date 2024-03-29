package com.collabera.account_management_system.entity;

import java.time.LocalDate;

import javax.annotation.Generated;
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
@Table(name = "biller_registered")
public class BillerRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "account_number")
	private long accountNumber;

	@Column(name = "timestamp")
	private LocalDate timeStamp;

	@Column(name = "consumer_number")
	private long consumerNumber;

	@Column(name = "biller_name")
	private String billerName;
	
	

}
