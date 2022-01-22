
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "billerprovider")
@NoArgsConstructor

public class BillerProvider {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@OneToMany(mappedBy = "billerProvider",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<BillerRegistered>  billerRegistered = new HashSet<BillerRegistered>();

	
	@Column(name="biller_name")
	private String billername;
	
	
	@Column(name="biller_account_no" , unique = true)
	private int billeraccountno;
}
