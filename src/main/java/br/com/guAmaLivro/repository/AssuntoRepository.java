package br.com.guAmaLivro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guAmaLivro.model.AssuntoModel;
import br.com.guAmaLivro.model.LivroModel;

public interface AssuntoRepository extends JpaRepository<AssuntoModel, Long>{


}
