package br.com.guAmaLivro.form;

import br.com.guAmaLivro.model.AutorModel;
import br.com.guAmaLivro.model.LivroModel;
import br.com.guAmaLivro.repository.AutorRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorForm {

	private String nome;
	
	public AutorModel convert() {
		return new AutorModel(nome);
	}
	public AutorModel atualizar(Long id ,AutorRepository autorRepository) {
		AutorModel am = autorRepository.getReferenceById(id);
		return am;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
