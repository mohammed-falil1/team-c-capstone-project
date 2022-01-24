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
@Table(name = "payee_table")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PayeeTable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="account_id")
	private Account accountId;

	@Column(name="short_name")
	private String shortName;
	
	@Column(name="payee_account_number")
	private int payeeAccountNumber;
	
	@Column(name="timestamp")
	private long timestamp;

}
