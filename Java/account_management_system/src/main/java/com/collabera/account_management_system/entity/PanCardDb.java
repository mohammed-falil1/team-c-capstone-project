package com.collabera.account_management_system.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pan_card")
@Component
public class PanCardDb {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

	@Column(name = "pancard_file_name")
	private String panCardFileName;

	@Column(name = "pancard_file_type")
	private String panCardFileType;

	@Lob
	@Column(name = "pancard")
	private byte[] panCard;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id_fk")
	private User user;


	


}
