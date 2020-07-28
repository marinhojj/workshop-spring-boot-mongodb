package com.marinho.workshopmongo.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marinho.workshopmongo.resources.exception.StandarError;
import com.marinho.workshopmongo.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotfound(ObjectNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandarError err = new StandarError(System.currentTimeMillis(), status.value(), "Não Encontrado", e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
