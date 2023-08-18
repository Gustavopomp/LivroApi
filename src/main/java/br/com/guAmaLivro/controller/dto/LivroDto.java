package br.com.guAmaLivro.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.guAmaLivro.model.LivroModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class LivroDto {

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

	public static List<LivroDto> convert(List<LivroModel> lm) {
		return lm.stream().map(LivroDto::new).collect(Collectors.toList());
	}



}
