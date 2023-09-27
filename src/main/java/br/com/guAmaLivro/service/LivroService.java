package br.com.guAmaLivro.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.guAmaLivro.controller.dto.LivroDto;
import br.com.guAmaLivro.form.LivroForm;
import br.com.guAmaLivro.mapper.DozerMapper;
import br.com.guAmaLivro.model.LivroModel;
import br.com.guAmaLivro.repository.LivroRepository;

@Service
public class LivroService {

	private Logger logger = Logger.getLogger(LivroService.class.getName());

	@Autowired
	LivroRepository livrorepository;

	public LivroDto gravar(LivroForm form) {

		logger.info("Creating one book!");
		LivroModel lm = form.convert();
		livrorepository.save(lm);
		LivroDto dto = new LivroDto(lm);
		return dto;
	}

	public List<LivroDto> buscar(Integer edicao) {
		if (edicao == null) {
			List<LivroModel> lm = livrorepository.findAll();
			return LivroDto.convert(lm);
		} else {
			List<LivroModel> lm = livrorepository.findByEdicao(edicao);
			return LivroDto.convert(lm);
		}
	}

	public ResponseEntity<LivroDto> deletar(Long id) {
		Optional<LivroModel> op = livrorepository.findById(id);
		if (op.isPresent()) {
			livrorepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<LivroDto> update(LivroForm form, Long id) {
		Optional<LivroModel> op = livrorepository.findById(id);
		if (op.isPresent()) {
			form.atualizar(id, livrorepository);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}