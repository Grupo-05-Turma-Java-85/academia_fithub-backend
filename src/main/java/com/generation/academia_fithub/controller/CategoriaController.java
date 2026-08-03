package com.generation.academia_fithub.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.academia_fithub.model.Categoria;
import com.generation.academia_fithub.repository.CategoriaRepository;

import jakarta.validation.Valid;

@Tag(name = "Categorias",
description = "Endpoints responsáveis pelo gerenciamento das categorias de exercícios da academia."
	)
@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Operation(summary = "Listar todas as categorias")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso")})
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(categoriaRepository.findAll());
	}

	@Operation(summary = "Buscar categoria por ID")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Categoria encontrada"),
	    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
	})
	@GetMapping("/{id}")
	public ResponseEntity<Categoria> getById(@PathVariable Long id) {
		return categoriaRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@Operation(summary = "Buscar categorias pelo nome")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Categorias encontradas")
	})
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Categoria>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(categoriaRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	@Operation(summary = "Cadastrar uma nova categoria")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "201", description = "Categoria cadastrada com sucesso"),
	    @ApiResponse(responseCode = "400", description = "Dados inválidos")
	})
	@PostMapping
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	}

	@Operation(summary = "Atualizar uma categoria")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso"),
	    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
	})
	@PutMapping
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria) {
		if (categoriaRepository.existsById(categoria.getId()))
			return ResponseEntity.ok(categoriaRepository.save(categoria));;
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Operation(summary = "Excluir uma categoria")
	@ApiResponses(value = {
	    @ApiResponse(responseCode = "204", description = "Categoria excluída com sucesso"),
	    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
	})
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		categoriaRepository.deleteById(id);
	}
}
