package br.com.guAmaLivro.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.guAmaLivro.controller.dto.LivroDto;
import br.com.guAmaLivro.form.LivroForm;
import br.com.guAmaLivro.model.LivroModel;
import br.com.guAmaLivro.repository.LivroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/livro")
public class LIvroController {
	@Autowired
	LivroRepository livrorepository;

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	@Transactional
	public ResponseEntity<LivroDto> PublicarLivro(@RequestBody @Valid LivroForm form, UriComponentsBuilder UriBuilder) {
		LivroModel lm = form.convert();
		livrorepository.save(lm);

		URI uri = UriBuilder.path("/livro/id").buildAndExpand(lm.getId()).toUri();
		return ResponseEntity.created(uri).body(new LivroDto(lm));
	}

	@GetMapping(produces = { "application/json" })
	public List<LivroDto> BuscarLivro(Integer edicao) {
		if (edicao == null) {
			List<LivroModel> lm = livrorepository.findAll();
			return LivroDto.convert(lm);
		} else {
			List<LivroModel> lm = livrorepository.findByEdicao(edicao);
			return LivroDto.convert(lm);
		}
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<LivroDto> AtualizarLivro(@RequestBody LivroForm form, @PathVariable Long id) {
		Optional<LivroModel> op = livrorepository.findById(id);
		if (op.isPresent()) {
			LivroModel lm = form.atualizar(id, livrorepository);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<LivroDto> DeletarLivro(@PathVariable Long id) {
		Optional<LivroModel> op = livrorepository.findById(id);
		if (op.isPresent()) {
			livrorepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
