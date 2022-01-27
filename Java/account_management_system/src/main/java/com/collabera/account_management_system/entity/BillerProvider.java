package com.collabera.account_management_system.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "biller_provider")
public class BillerProvider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "consumer_number")
	private long consumerNumber;
	
	@Column(name ="timestamp", nullable = true)
	private LocalDate timestamp;
	
	@Column(name = "account_id")
	private long accountId;
	
	@Column(name = "biller_name ")
	private String billerName ;
}

