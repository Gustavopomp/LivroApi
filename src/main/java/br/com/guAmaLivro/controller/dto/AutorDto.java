package br.com.guAmaLivro.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.guAmaLivro.model.AutorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class AutorDto {

	private String nome;

	public AutorDto(AutorModel am) {
		super();
		this.nome = nome;
	}

	public static List<AutorDto> convert(List<AutorModel> am) {
		return am.stream().map(AutorDto::new).collect(Collectors.toList());
	}
}
