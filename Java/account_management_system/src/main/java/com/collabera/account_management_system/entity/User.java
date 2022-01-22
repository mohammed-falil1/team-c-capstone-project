package com.collabera.account_management_system.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "application_id" , unique = true)
	private long applicationId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name ="full_name")
	private String fullName;
	
	@Column(name ="dob")
	private String dob;
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile_number" )
	private int mobileNumber;
	
	@Column(name ="pan_card")
	private int panCard;
	
	@Column(name ="aadhar")
	private int aadhar;
	
	@Column(name = "upload_address")
	private String uploadAddress;
	
	@Column(name = "initial_balance")
	private int initialBalance;
	
	@Column(name = "time_stamp")
	private long timestamp;
	
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<Account>  account = new HashSet<Account>();
	
	
	@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private Set<AccountApproval> accountApproval = new HashSet<AccountApproval>();
	
		

}
