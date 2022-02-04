package com.collabera.account_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import com.collabera.account_management_system.entity.AadharDb;
import com.collabera.account_management_system.entity.User;
import com.collabera.account_management_system.service.FileService;
import com.collabera.account_management_system.service.VistorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.collabera.account_management_system.Vo.ResponseFile;
import com.collabera.account_management_system.entity.PanCardDb;
import org.springframework.web.bind.annotation.ModelAttribute;

@RestController
@RequestMapping("/visit")
@CrossOrigin(origins = "http://localhost:3000/")
public class VisitorController {

	@Autowired
	VistorService vistorService;

	@Autowired
	FileService fileService;

	@Autowired
	ResponseFile responseFile;

	@Autowired
	Optional<AadharDb> aadhar;

	@Autowired
	Optional<PanCardDb> panCard;

	@PostMapping("/new-account")
	public ResponseEntity<String> createAccount(@RequestBody User user) {

		String response = vistorService.createAccount(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}


	@PostMapping(name = "/upload-aadhar")
	public ResponseEntity<ResponseFile> uploadAadhar(@RequestParam("aadharFile") MultipartFile aadharFile) throws IOException {

		responseFile = fileService.storeAadhar(aadharFile);

		return ResponseEntity.ok(responseFile);

	}

	@GetMapping("/download-aadhar/{id}")
	public ResponseEntity<Resource> downloadAadhar(@PathVariable int id) {
		aadhar = fileService.getAadharFromDb(id);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + aadhar.get().getAadharFileName() + "\"")
				.contentType(MediaType.parseMediaType(aadhar.get().getAadharFileType()))
				.body(new ByteArrayResource(aadhar.get().getAadharCard()));
	}

	@PostMapping("/upload-pancard")
	public ResponseEntity<ResponseFile> uploadPanCard(@RequestParam("panCardFile") MultipartFile panCardFile) throws IOException {

		responseFile = fileService.storePanCard(panCardFile);

		return ResponseEntity.ok(responseFile);

	}

	@GetMapping("/download-pancard/{id}")
	public ResponseEntity<Resource> downloadPanCard(@PathVariable String id) {
		panCard = fileService.getPanCardFromDb(id);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment; filename=\"" + panCard.get().getPanCardFileName() + "\"")
				.contentType(MediaType.parseMediaType(panCard.get().getPanCardFileType()))
				.body(new ByteArrayResource(panCard.get().getPanCard()));
	}

}
