package br.com.erudio.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.erudio.exception.ExceptionResponse;
import br.com.erudio.exception.UnsuportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends  ResponseEntityExceptionHandler {
//tratamento de excessoes
	@ExceptionHandler //filtro que intercepta as excessões captura a mensagem e devolver a msg do servidor com a data, msg e descrição
	public final ResponseEntity<ExceptionResponse> handleAllExceptions (Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);//mensagem genérica de erro
	}
	
	@ExceptionHandler (UnsuportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions (Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ExceptionResponse> (exceptionResponse, HttpStatus.BAD_REQUEST);
	}

}
