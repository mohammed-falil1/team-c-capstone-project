package com.collabera.account_management_system.entity;

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


@Entity
@Table(name = "transaction_table")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TransactionTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="account_number_fk",nullable = false)
	private Account accountId;
	
	@Column(name="transaction_type")
	private String transactionType;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="transaction_id", unique = true)
	private int transactionId;
	
	@Column(name="timestamp")
	private long timestamp;
	
	@Column(name="remarks")
	private String remarks;

}