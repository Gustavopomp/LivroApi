package br.com.guAmaLivro.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationErrorHander {
	@Autowired
	private MessageSource menssagesource;

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)

	public List<ExceptionResponse> hander(MethodArgumentNotValidException exception) {
		List<ExceptionResponse> retorno = new ArrayList<ExceptionResponse>();
		List<FieldError> fieldErros = exception.getBindingResult().getFieldErrors();
		fieldErros.forEach(e -> {
			String message = menssagesource.getMessage(e, LocaleContextHolder.getLocale());
			ExceptionResponse erro = new ExceptionResponse(new Date(), e.getField(), message);
			retorno.add(erro);
		});
		return retorno;
	}
}
