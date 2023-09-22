package br.com.guAmaLivro.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.dozermapper.core.Mapping;

import br.com.guAmaLivro.model.LivroModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LivroDto {

	private static final long serialVersionUID = 1L;


	private Long key;
	private String titulo;
	private String editora;
	private int edicao;
	private String anoDePublicacao;

	public LivroDto(LivroModel lm) {
		this.titulo = lm.getTitulo();
		this.editora = lm.getEditora();
		this.edicao = lm.getEdicao();
		this.anoDePublicacao = lm.getAnoDePublicacao();
	}

	public LivroDto() {
	}
<<<<<<< HEAD
	
=======

>>>>>>> 8d0346da20e15d0bf5b887c5304da5f9ee3248f7
	public static List<LivroDto> convert(List<LivroModel> lm) {
		return lm.stream().map(LivroDto::new).collect(Collectors.toList());
	}

	public Long getKey() {
		return key;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public String getAnoDePublicacao() {
		return anoDePublicacao;
	}

	public void setAnoDePublicacao(String anoDePublicacao) {
		this.anoDePublicacao = anoDePublicacao;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
