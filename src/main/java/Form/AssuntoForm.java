package Form;

import Model.AssuntoModel;
import Model.LivroModel;
import Repository.AssuntoRepository;
import Repository.AutorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssuntoForm {

	private String descricao;

	public AssuntoModel convert() {
		return new AssuntoModel(descricao);
	}
	public AssuntoModel atualizar(Long id ,AssuntoRepository assuntoRepository) {
		AssuntoModel am = assuntoRepository.getReferenceById(id);
		am.setDescricao(this.descricao);
		return am;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
