package com.collabera.account_management_system.Vo;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ResponseFile {

	private String name;
	private String url;
	private String type;
	private long size;


}
