package com.desafioapi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.desafioapi.dto.ApiErrorDTO;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ApiException.class})
	public ResponseEntity<ApiErrorDTO> handleLojaExcpetion(ApiException ex, WebRequest request) {
		
		String error = "Erro no sistema";
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(),error,HttpStatus.INTERNAL_SERVER_ERROR);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(),apiError.getStatus());
	}
	
	//Se a entidade não for encontrada
	@ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<ApiErrorDTO> handleLojaExcpetion(EntityNotFoundException ex, WebRequest request) {
		
		String error = "Recurso não encontrado";
		ApiErrorDTO apiError = new ApiErrorDTO(ex.getMessage(),error,HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ApiErrorDTO>(apiError, new HttpHeaders(),apiError.getStatus());
	}

}
