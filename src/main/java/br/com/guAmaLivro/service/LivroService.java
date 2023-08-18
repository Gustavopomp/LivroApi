package br.com.guAmaLivro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.guAmaLivro.controller.dto.LivroDto;
import br.com.guAmaLivro.form.LivroForm;
import br.com.guAmaLivro.model.LivroModel;
import br.com.guAmaLivro.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livrorepository;
	
	public LivroDto gravar(LivroForm form) {
		LivroModel lm = form.convert();
		livrorepository.save(lm);

		
		return new LivroDto(lm);
	}
	
	public List<LivroDto> buscar(Integer edicao){
		if (edicao == null) {
			List<LivroModel> lm = livrorepository.findAll();
			return LivroDto.convert(lm);
		} else {
			List<LivroModel> lm = livrorepository.findByEdicao(edicao);
			return LivroDto.convert(lm);
		}
	}
	
	
		public ResponseEntity<LivroDto> deletar(Long id, Optional<LivroModel> op){
			if (op.isPresent()) {
				livrorepository.deleteById(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();
		}
		
	}


