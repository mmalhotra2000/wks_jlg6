package com.example.demowebservice1jlg6;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class MyResponseEnttityExpHandler extends ResponseEntityExceptionHandler {

	Logger logger = LoggerFactory.getLogger(MyResponseEnttityExpHandler.class);

	@Autowired
	private ExceptionResponseRepository exceptionResponseRepository;

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {

		logger.info("Entring handleUserNotFoundException");

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		exceptionResponseRepository.save(exceptionResponse);

		logger.info("Exiting handleUserNotFoundException");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {

		logger.info("Entring handleAllException");

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		exceptionResponseRepository.save(exceptionResponse);

		logger.info("Exiting handleAllException");

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

	}
}
