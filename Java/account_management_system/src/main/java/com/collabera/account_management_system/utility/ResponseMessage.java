package com.collabera.account_management_system.utility;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMessage {

	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;

}
