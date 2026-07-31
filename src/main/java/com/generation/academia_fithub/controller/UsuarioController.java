package com.generation.academia_fithub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.academia_fithub.model.Exercicio;
import com.generation.academia_fithub.model.Usuario;
import com.generation.academia_fithub.model.UsuarioLogin;
import com.generation.academia_fithub.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {//CUIDA DA INTERAÇÃO COM O USUÁRIO
	
	private final AuthenticationManager authenticationManager;
	@Autowired
	private UsuarioService usuarioService;

	UsuarioController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	
	//MÉTODOS GET
	//1. LISTAR TODOS
	@GetMapping("/all")
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(usuarioService.getAll());
	}
		
	//2. LISTAR POR ID
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id){
		return usuarioService.getById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//3. LISTAR POR USUARIO
	@GetMapping("/usuario/{usuario}")
	public ResponseEntity<Usuario> getByUsuario(@PathVariable String usuario){
	    return usuarioService.getByUsuario(usuario)
	            .map(resposta -> ResponseEntity.ok(resposta))
	            .orElse(ResponseEntity.notFound().build());
	}
	
	//4. LISTAR IMC DE CADA USUARIO
	@GetMapping("/imc/{id}")
	public ResponseEntity<Double> calcularIMC(@PathVariable Long id){
		return ResponseEntity.ok(usuarioService.calcularIMC(id));
	}
	
	
	//MÉTODO POST - CADASTRAR
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario usuario){
		return usuarioService.cadastrarUsuario(usuario)
				.map(resposta -> ResponseEntity.status(HttpStatus.CREATED).body(resposta))
				.orElse(ResponseEntity.badRequest().build());
	}
		
		
	//MÉTODO PUT - ATUALIZAR
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> put(@Valid @RequestBody Usuario usuario){
		return usuarioService.atualizarUsuario(usuario)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
		
	@PostMapping("/logar")
	public ResponseEntity<UsuarioLogin> autenticar(@Valid @RequestBody Optional<UsuarioLogin> usuarioLogin){
		return usuarioService.autenticarUsuario(usuarioLogin)
				.map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	

}
