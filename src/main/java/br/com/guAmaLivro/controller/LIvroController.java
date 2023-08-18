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
import br.com.guAmaLivro.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/livro/v1")
public class LIvroController {
	@Autowired
	LivroRepository livrorepository;

	@Autowired
	LivroService service;

	@PostMapping
	@Operation(summary = "Adds a new Book",
			description = "Adds a new Book by passing in a JSON, XML or YML representation of the Book!",
			tags = {"Book"},
			responses = {
				@ApiResponse(description = "Success", responseCode = "200",
					content = @Content(schema = @Schema(implementation = LivroDto.class))
				),
				@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
				@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
				@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
			}
		)
	@Transactional
	public ResponseEntity<LivroDto> PublicarLivro(@RequestBody @Valid LivroForm form, UriComponentsBuilder UriBuilder) {
		LivroDto dto = service.gravar(form);
		URI uri = UriBuilder.path("/livro/id").buildAndExpand(1).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	
	@GetMapping(produces = { "application/json" })
	@Operation(summary = "Finds all books", description = "Finds all books",
	tags = {"Book"},
	responses = {
		@ApiResponse(description = "Success", responseCode = "200",
			content = {
				@Content(
					mediaType = "application/json",
					array = @ArraySchema(schema = @Schema(implementation = LivroDto.class))
				)
			}),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	})
	public List<LivroDto> BuscarLivro(Integer edicao) {
		List<LivroDto> dto = service.buscar(edicao);
		return dto;
	}

	@PutMapping("/{id}")
	@Operation(summary = "Updates a Book",
	description = "Updates a Book by passing in a JSON, XML or YML representation of the Book!",
	tags = {"Book"},
	responses = {
		@ApiResponse(description = "Updated", responseCode = "200",
			content = @Content(schema = @Schema(implementation = LivroDto.class))
		),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
)
	@Transactional
	public ResponseEntity<LivroDto> AtualizarLivro(@RequestBody LivroForm form, @PathVariable Long id) {
		Optional<LivroModel> op = livrorepository.findById(id);
		if(op.isPresent()) {
			LivroModel model = form.atualizar(id, livrorepository);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletes a Book",
	description = "Deletes a Book by passing in a JSON, XML or YML representation of the Book!",
	tags = {"Book"},
	responses = {
		@ApiResponse(description = "No Content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content),
	}
)
	@Transactional
	public ResponseEntity<LivroDto> DeletarLivro(@PathVariable Long id) {
		Optional<LivroModel> op = livrorepository.findById(id);
		ResponseEntity<LivroDto> dto = service.deletar(id, op);
		return dto;
}}
