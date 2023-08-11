package br.com.guAmaLivro.exception;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private Date timeStamp;
	private String mensagem;
	private String details;
	
	public ExceptionResponse(Date timeStamp, String mensagem, String details) {
		super();
		this.timeStamp = timeStamp;
		this.mensagem = mensagem;
		this.details = details;
	}
	
	public ExceptionResponse() {
	}

	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
