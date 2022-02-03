package com.collabera.account_management_system.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
@Component
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "account_number", unique = true)
	private long accountNumber;

	@Column(name = "balance")
	private long balance;

	@Column(name = "timestamp")
	private LocalDate timestamp;

	@Column(name = "user_id")
	private int userId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_fk")
	private User user;

//	@OneToMany(mappedBy = "accountId", fetch = FetchType.LAZY)
//	private Set<PayeeTable> payee = new HashSet<>();
//
//	@OneToMany(mappedBy = "accountId", fetch = FetchType.LAZY)
//	private Set<BillerProvider> billerProvider = new HashSet<>();
////
//	@OneToMany(mappedBy = "accountId", fetch = FetchType.LAZY)
//	private Set<TransactionTable> transaction = new HashSet<>();

}
