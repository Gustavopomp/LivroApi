package br.com.guAmaLivro.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.guAmaLivro.model.AssuntoModel;
import br.com.guAmaLivro.model.LivroModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class AssuntoDto {

	private String descricao;

	public static List<AssuntoDto> convert(List<AssuntoModel> lm) {
		return lm.stream().map(AssuntoDto::new).collect(Collectors.toList());
	}

	public AssuntoDto(AssuntoModel am) {
		super();
		this.descricao = descricao;
	}
}
