package com.desafioapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafioapi.controllers.form.AutenticacaoForm;
import com.desafioapi.dto.TokenDTO;
import com.desafioapi.services.AutenticacaoService;



@RestController
@RequestMapping("v1/auth")
public class AutenticacaoController {
	
	@Autowired
	AutenticacaoService autenticacaoService;
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoForm authForm){
		
		try {
			return ResponseEntity.ok(autenticacaoService.autenticar(authForm));
		}catch (AuthenticationException ae) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
	}


}
