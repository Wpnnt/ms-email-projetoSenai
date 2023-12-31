package com.senai.msemail.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.senai.msemail.dtos.EmailModelDTO;
import com.senai.msemail.entities.EmailModel;
import com.senai.msemail.services.EmailService;

import jakarta.validation.Valid;

@RestController
public class EmailController {

	@Autowired
	private EmailService service;

	@PostMapping("/sending-email")
	public ResponseEntity<EmailModel> enviarEmail(@RequestBody @Valid EmailModelDTO dto) {
		EmailModel emailModel = new EmailModel();
		BeanUtils.copyProperties(dto, emailModel);
		service.enviarEmail(emailModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(emailModel);
	}
}
