package Dto;

import java.util.List;
import java.util.stream.Collectors;

import Model.AutorModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
