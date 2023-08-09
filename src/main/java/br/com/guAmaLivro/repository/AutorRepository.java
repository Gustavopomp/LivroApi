package br.com.guAmaLivro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guAmaLivro.model.AutorModel;

public interface AutorRepository extends JpaRepository<AutorModel, Long> {

}
