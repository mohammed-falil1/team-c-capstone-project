package com.collabera.account_management_system.service;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.collabera.account_management_system.Vo.ResponseFile;
import com.collabera.account_management_system.entity.AadharDb;
import com.collabera.account_management_system.entity.PanCardDb;
import com.collabera.account_management_system.repo.AadharRepo;
import com.collabera.account_management_system.repo.PanCardRepo;

@Service
public class FileService {

	@Autowired
	AadharRepo aadharRepo;

	@Autowired
	PanCardRepo panCardRepo;

	@Autowired
	ResponseFile responseFile;

	public ResponseFile storeAadhar(MultipartFile aadhar) throws IOException {
		AadharDb aadharDb = new AadharDb();
		String fileName = StringUtils.cleanPath(aadhar.getName());
		aadharDb.setAadharFileName(fileName);
		aadharDb.setAadharFileType(aadhar.getContentType());
		aadharDb.setAadharCard(aadhar.getBytes());

		AadharDb returnFile = aadharRepo.save(aadharDb);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/visit/download-aadhar/")
				.path(String.valueOf(aadharDb.getUuid())).toUriString();

		responseFile.setName(returnFile.getAadharFileName());
		responseFile.setUrl(fileDownloadUri);
		responseFile.setSize(aadhar.getSize());
		responseFile.setType(returnFile.getAadharFileType());

		return responseFile;

	}

	public Optional<AadharDb> getAadharFromDb(int id) {

		return aadharRepo.findAadharByUuid(id);
	}

	public ResponseFile storePanCard(MultipartFile panCard) throws IOException {
		PanCardDb panCardDb = new PanCardDb();
		String fileName = StringUtils.cleanPath(panCard.getName());
		panCardDb.setPanCardFileName(fileName);
		panCardDb.setPanCardFileType(panCard.getContentType());
		panCardDb.setPanCard(panCard.getBytes());

		PanCardDb returnFile = panCardRepo.save(panCardDb);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/visit/download-pancard/")
				.path(panCardDb.getId()).toUriString();

		responseFile.setName(returnFile.getPanCardFileName());
		responseFile.setUrl(fileDownloadUri);
		responseFile.setSize(panCard.getSize());
		responseFile.setType(returnFile.getPanCardFileType());

		return responseFile;

	}

	public Optional<PanCardDb> getPanCardFromDb(String id) {

		return panCardRepo.findById(id);
	}

}
