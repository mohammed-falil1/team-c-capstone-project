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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "billerregistered")
@NoArgsConstructor

public class BillerRegistered {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="biller_register_id")
	private int billerregisterid;
	
	
	
	@Column(name="biller_provider_id")
	private int billerproviderid;
	
	
	@Column(name="account_No")
	private int accountnumber;
	
	@Column(name="consumer_No" , unique = true)
	private int consumernumber;
	
	@Column(name="timestamp")
	private long timestamp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="biller_provider_fk",nullable = false)
	private BillerProvider billerProvider; 
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="account_id_fk",nullable = false)
	private Account accountId; 
	
	

}
