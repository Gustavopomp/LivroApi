package br.com.guAmaLivro.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import br.com.guAmaLivro.controller.LIvroController;
import br.com.guAmaLivro.controller.dto.LivroDto;
<<<<<<< HEAD
import br.com.guAmaLivro.exception.ResourceNotFoundException;
import br.com.guAmaLivro.form.LivroForm;
=======
>>>>>>> 8d0346da20e15d0bf5b887c5304da5f9ee3248f7
import br.com.guAmaLivro.mapper.DozerMapper;
import br.com.guAmaLivro.model.LivroModel;
import br.com.guAmaLivro.repository.LivroRepository;


@Service
public class LivroService {

	private Logger logger = Logger.getLogger(LivroService.class.getName());

	@Autowired
	LivroRepository livrorepository;

<<<<<<< HEAD
	public LivroDto gravar(LivroForm form) {
		logger.info("Creating a Book!");
		LivroModel lm = form.convert();
		LivroDto livro = new LivroDto(lm);
		livrorepository.save(livro);
		return livro;
=======
	public LivroDto create(LivroDto form) {

		if (form == null) throw new Exception();
		
		logger.info("Creating one book!");
		var entity = DozerMapper.parseObject(form, LivroModel.class);
		var dto =  DozerMapper.parseObject(livrorepository.save(entity), LivroDto.class);
		dto.add(linkTo(methodOn(LIvroController.class).findById(dto.getKey())).withSelfRel());
		return dto;
	}

	public List<LivroDto> findAll() {

		logger.info("Finding all people!");

		return DozerMapper.parseListObjects(livrorepository.findAll(), LivroDto.class);
>>>>>>> 8d0346da20e15d0bf5b887c5304da5f9ee3248f7
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

	public ResponseEntity<LivroDto> deletar(Long id, Optional<LivroModel> op) {
		if (op.isPresent()) {
			livrorepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

/*public LivroDto update(LivroDto livro,LivroModel ml) {
	
	logger.info("Updating a Book");
	
	var entity = livrorepository.findById(ml.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
	var dto =  DozerMapper.parseObject(livrorepository.save(entity), LivroDto.class);
	return dto;
}*/
}