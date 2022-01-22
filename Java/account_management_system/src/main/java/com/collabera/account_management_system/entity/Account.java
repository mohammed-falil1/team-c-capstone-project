package com.collabera.account_management_system.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "account_number" , unique = true)
	private int accountNumber;

	@Column(name = "balance")
	private long balance;
	
	@Column(name ="timestamp")
	private long timestamp;
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="user_fk",nullable = false)
	private User user;
	
//	@OneToMany(fetch = FetchType.LAZY)
//	private Set<AccountApproval> accountApproval = new HashSet<>();
	
	
	

	
	
	

}
