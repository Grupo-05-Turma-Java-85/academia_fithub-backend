package com.generation.academia_fithub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.generation.academia_fithub.model.Usuario;
import com.generation.academia_fithub.model.UsuarioLogin;
import com.generation.academia_fithub.repository.UsuarioRepository;
import com.generation.academia_fithub.security.JwtService;

@Service
public class UsuarioService {//REGRAS DE NEGÓCIO
	
	//INJEÇÕES DE DEPENDÊNCIA
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	@Autowired
	private JwtService jwtService;
		
	@Autowired
	private AuthenticationManager authenticationManager;
		
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	//MÉTODOS GET
	//1. LISTAGEM DE USUÁRIOS
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
		
	//2. LISTAR PELO ID
	public Optional<Usuario> getById(Long id) {
		return usuarioRepository.findById(id);
	}
	
	//3. LISTAR POR USUARIO
	public Optional<Usuario> getByUsuario(String usuario){
		   return usuarioRepository.findByUsuario(usuario);
	}
		
	
	//MÉTODO CADASTRAR USUÁRIO
	public Optional<Usuario> cadastrarUsuario(Usuario usuario){
		
			
		//VERIFICA SE JÁ EXISTE NO BANCO
		if(usuarioRepository.findByUsuario(usuario.getUsuario()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário já cadastrado.");
		}
		
		//CRIPTOGRAFAR SENHA E LIMPAR ID
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuario.setId(null); //O BD QUE DEFINE O ID
		
		//CRIAR OPTIONAL QUE CONTÉM O USUÁRIO E SALVADAR NO BANCO
		return Optional.of(usuarioRepository.save(usuario));
			
	}	
		
	
	//MÉTODO ATUALIZAR
	public Optional<Usuario> atualizarUsuario(Usuario usuario){
		
				
		//VERIFICA SE NÃO TEM USUÁRIO
		if(usuarioRepository.findById(usuario.getId()).isEmpty()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não existe.");
		}
		
		Optional<Usuario> usuarioExistente = usuarioRepository.findByUsuario(usuario.getUsuario());
		
		if(usuarioExistente.isPresent() && !usuarioExistente.get().getId().equals(usuario.getId()))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O e-mail já está em uso!", null);
			
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		
		return Optional.ofNullable(usuarioRepository.save(usuario));
	}
	
	
	//MÉTODO AUTENTICAR
	public Optional<UsuarioLogin> autenticarUsuario(Optional<UsuarioLogin> usuarioLogin) {
			 
		if (usuarioLogin.isEmpty()) {
			return Optional.empty();
		}
	 
		UsuarioLogin login = usuarioLogin.get();	
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(login.getUsuario(), login.getSenha()));
	 
			return usuarioRepository.findByUsuario(login.getUsuario())
				.map(usuario -> construirRespostaLogin(login, usuario));
	
		} catch (Exception e) {
	 
			return Optional.empty();
		}
	}
	
	
	//MÉTODO CONSTRUIR RESPOSTA LOGIN
	private UsuarioLogin construirRespostaLogin(UsuarioLogin usuarioLogin, Usuario usuario){
		usuarioLogin.setId(usuario.getId());
		usuarioLogin.setNome(usuario.getNome());
		usuarioLogin.setFoto(usuario.getFoto());
		usuarioLogin.setSenha("");
		usuarioLogin.setToken(gerarToken(usuario.getUsuario()));
			
		return usuarioLogin;
	}
		
		
	//MÉTODO GERAR TOKEN
	private String gerarToken(String usuario) {
		return "Bearer " + jwtService.generateToken(usuario);
	}
	
	
	//MÉTODO CALCULAR IMC
	public Double calcularIMC(Long id) {
		Usuario usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));
	
		return usuario.calcularIMC();
	}
	
}
