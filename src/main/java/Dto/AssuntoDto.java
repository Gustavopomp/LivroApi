package Dto;

import java.util.List;
import java.util.stream.Collectors;

import Model.AssuntoModel;
import Model.LivroModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
