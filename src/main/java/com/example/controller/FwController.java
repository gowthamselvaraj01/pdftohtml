package com.example.controller;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.constants.FileConstants;
import com.example.dao.FrameworkRepo;
import com.example.exception.HTMLfileCreationException;
import com.example.model.Framework;
import com.example.service.PdfService;

@RestController
public class FwController {
	
	@Autowired
	FrameworkRepo repo;
	
	@Autowired
	PdfService pdfService;
	
	private static final Logger logger = LoggerFactory.getLogger(FwController.class);
	
	
	
	@PostMapping(value = "/convert-html")
	  public ResponseEntity<String> convertToHtml(@RequestParam MultipartFile file) throws IOException {
		String msg = null;
			logger.info("In Controller start time.. "+ LocalDateTime.now());
			msg = pdfService.generateHTMLfile(file.getInputStream());
			logger.info("In Controller end time.. "+ LocalDateTime.now());
			if(msg==null || msg.isEmpty()) {
				logger.info("In if block..");
				throw new HTMLfileCreationException(FileConstants.EXCEPTION_MSG_1);
			}
		  
	   return ResponseEntity.ok(msg);
	  }
	

}
