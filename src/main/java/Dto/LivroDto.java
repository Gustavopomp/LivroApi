package Dto;

import java.util.List;
import java.util.stream.Collectors;

import Model.LivroModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDto {

	private String titulo;
	private String editora;
	private int edicao;
	private String anoDePublicacao;

	public LivroDto(LivroModel lm) {
		this.titulo = titulo;
		this.editora = editora;
		this.edicao = edicao;
		this.anoDePublicacao = anoDePublicacao;
	}

	public static List<LivroDto> convert(List<LivroModel> lm) {
		return lm.stream().map(LivroDto::new).collect(Collectors.toList());
	}



}
