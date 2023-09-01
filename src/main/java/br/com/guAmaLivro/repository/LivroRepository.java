package br.com.guAmaLivro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guAmaLivro.controller.dto.LivroDto;
import br.com.guAmaLivro.model.LivroModel;

public interface LivroRepository extends JpaRepository<LivroModel, Long>{

	List<LivroModel> findByEdicao(Integer edicao);

	Object save(LivroDto entity);

}
