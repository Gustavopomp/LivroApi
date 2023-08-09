package br.com.guAmaLivro.exception.hander;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice

public class CustomizeResponseEntityExceptionHander extends ResponseEntityExceptionHandler{
//	@ExceptionHandler(Exception.class)

}
