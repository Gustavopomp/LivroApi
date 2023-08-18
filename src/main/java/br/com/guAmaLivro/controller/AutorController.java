package br.com.guAmaLivro.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.guAmaLivro.controller.dto.AutorDto;
import br.com.guAmaLivro.controller.dto.LivroDto;
import br.com.guAmaLivro.form.AutorForm;
import br.com.guAmaLivro.form.LivroForm;
import br.com.guAmaLivro.model.AutorModel;
import br.com.guAmaLivro.model.LivroModel;
import br.com.guAmaLivro.repository.AutorRepository;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/autor/v1")
public class AutorController {

	@Autowired
	AutorRepository autorRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> PostarAutor(@RequestBody AutorForm form ,UriComponentsBuilder Uribuilder ){
		AutorModel am = form.convert();
		autorRepository.save(am);
		
		URI uri = Uribuilder.path("autor/id").buildAndExpand(am.getId()).toUri();
		return ResponseEntity.created(uri).body(new AutorDto(am));
	}
	@GetMapping
	public List<AutorDto> BuscarLivro(){
			List<AutorModel> lm = autorRepository.findAll();
			return AutorDto.convert(lm);
	}
	
	@PutMapping("/{id}")
	@Validated
	public ResponseEntity<AutorDto> AtualizarLivro(@RequestBody AutorForm form, @PathVariable Long id){
		Optional<AutorModel> op = autorRepository.findById(id);
		if(op.isPresent()) {
			AutorModel lm = form.atualizar(id, autorRepository);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@Validated
	public ResponseEntity<LivroDto> DeletarLivro(@PathVariable Long id){
		Optional<AutorModel> op = autorRepository.findById(id);
		if(op.isPresent()) {
			autorRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
}
