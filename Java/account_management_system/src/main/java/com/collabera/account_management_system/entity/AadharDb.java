package com.collabera.account_management_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Lob;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aadhar")
@Component
public class AadharDb {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uuid;
//
//	@Id
//	@GeneratedValue(generator = "uuid",strategy = GenerationType.IDENTITY)
//	@GenericGenerator(name = "uuid", strategy = "uuid2")
//	@Column(updatable = false,unique = true,nullable = false)

//	private String uuid;

	@Column(name = "aadhar_file_name")
	private String aadharFileName;

	@Column(name = "aadhar_file_type")
	private String aadharFileType;

	@Lob
	@Column(name = "aadharCard")
	private byte[] aadharCard;

	@OneToOne(mappedBy = "aadharDb", fetch = FetchType.LAZY)
	private User user;

}
