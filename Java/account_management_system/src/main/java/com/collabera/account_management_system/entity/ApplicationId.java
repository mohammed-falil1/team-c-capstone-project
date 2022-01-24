package com.collabera.account_management_system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="application_id")
@Component
public class ApplicationId {
	
	@Id
	@Column(columnDefinition = "integer  default 1",nullable = false)
	private int id=1;
	
	
	@Column(name = "application_id" , columnDefinition = "integer  default 1001", nullable = false)
	private int applicationId;
	
	
	

}
