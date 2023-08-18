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

import br.com.guAmaLivro.controller.dto.AssuntoDto;
import br.com.guAmaLivro.controller.dto.LivroDto;
import br.com.guAmaLivro.form.AssuntoForm;
import br.com.guAmaLivro.form.LivroForm;
import br.com.guAmaLivro.model.AssuntoModel;
import br.com.guAmaLivro.model.LivroModel;
import br.com.guAmaLivro.repository.AssuntoRepository;
import br.com.guAmaLivro.repository.LivroRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/assunto/v1")
public class AssuntoController {
	@Autowired
	AssuntoRepository assuntoRepository;

	@PostMapping(produces = { "application/json", "application/xml", "application/x-yaml" }, consumes = {
			"application/json", "application/xml", "application/x-yaml" })
	@Transactional
	public ResponseEntity<AssuntoDto> PublicarLivro(@RequestBody AssuntoForm form, UriComponentsBuilder UriBuilder) {
		AssuntoModel lm = form.convert();
		assuntoRepository.save(lm);

		URI uri = UriBuilder.path("/assunto/id").buildAndExpand(lm.getId()).toUri();
		return ResponseEntity.created(uri).body(new AssuntoDto(lm));
	}

	@GetMapping(produces = { "application/json" })
	public List<AssuntoDto> BuscarLivro() {

		List<AssuntoModel> lm = assuntoRepository.findAll();
		return AssuntoDto.convert(lm);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AssuntoDto> AtualizarLivro(@RequestBody AssuntoForm form, @PathVariable Long id) {
		Optional<AssuntoModel> op = assuntoRepository.findById(id);
		if (op.isPresent()) {
			AssuntoModel lm = form.atualizar(id, assuntoRepository);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<AssuntoDto> DeletarLivro(@PathVariable Long id) {
		Optional<AssuntoModel> op = assuntoRepository.findById(id);
		if (op.isPresent()) {
			assuntoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
