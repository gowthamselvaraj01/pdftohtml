package com.example.service.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.fit.pdfdom.PDFDomTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.constants.FileConstants;
import com.example.exception.HTMLfileCreationException;
import com.example.service.PdfService;

@Component
public class PdfServiceImpl implements PdfService{
	
	
	private static final Logger logger = LoggerFactory.getLogger(PdfServiceImpl.class);

	@Override
	public String generateHTMLfile(InputStream inputStream) {
		
		 PDDocument pdf;
		 Writer output = null;
		 String msg = null;
		try {
			logger.info("In service impl...");
			pdf = PDDocument.load(inputStream);
		    output = new PrintWriter(FileConstants.FIlE_NAME, FileConstants.UTF);
		    new PDFDomTree().writeText(pdf, output);
		    output.close();
		    
		    if(new File(FileConstants.FIlE_NAME).exists()) {
		    	msg = FileConstants.SUCCESS;
		    	logger.info(FileConstants.SUCCESS_MSG);
		    }
		    else {
		    	msg = FileConstants.FAILURE;
		    	logger.info(FileConstants.FAILURE_MSG);
		    	throw new HTMLfileCreationException(FileConstants.EXCEPTION_MSG_1);
		    }
		    
		} catch (IOException e) {
			throw new HTMLfileCreationException(e.getMessage());
		}
	
		return msg;
	}

}
