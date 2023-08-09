package br.com.guAmaLivro.form;

import br.com.guAmaLivro.model.LivroModel;
import br.com.guAmaLivro.repository.LivroRepository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroForm {

	@NotBlank
	@NotEmpty
	private String titulo;
	@NotBlank
	@NotEmpty
	private String editora;
	@NotNull
	@NotEmpty
	private int edicao;
	@NotBlank
	@NotEmpty
	private String anoDePublicacao;

	public LivroModel convert() {
		return new LivroModel(titulo, editora, edicao, anoDePublicacao);
	}

	public LivroModel atualizar(Long id, LivroRepository livrorepository) {
		LivroModel lm = livrorepository.getReferenceById(id);
		lm.setAnoDePublicacao(anoDePublicacao);
		lm.setEdicao(edicao);
		lm.setEditora(editora);
		lm.setTitulo(titulo);
		return lm;
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

}
