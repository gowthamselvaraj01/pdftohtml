package com.example.service;

import java.io.InputStream;

import org.springframework.stereotype.Component;
@Component
public interface PdfService {
	
	
	String generateHTMLfile(InputStream inputStream);

}
