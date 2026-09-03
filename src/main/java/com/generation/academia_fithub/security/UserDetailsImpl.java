package com.generation.academia_fithub.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.generation.academia_fithub.model.Usuario;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	//ATRIBUTOS PADRÕES
	private String username;
	private String password;
	private Usuario user;

	//MÉTODO CONSTRUTOR
	public UserDetailsImpl(Usuario user) {
		this.user = user;
		this.username = user.getUsuario();
		this.password = user.getSenha();
	}
	
	//MÉTODOS SOBRECARREGADOS
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

	    if (user.getTipoUsuario() == 2) {
	        return Collections.singletonList(
	            new SimpleGrantedAuthority("ROLE_ADMIN")
	        );
	    }

	    return Collections.singletonList(
	        new SimpleGrantedAuthority("ROLE_ALUNO")
	    );
	}

	//RECUPERA USUÁRIO E SENHA
	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}
	
	//MÉTODOS QUE INDICAM RESTRIÇÕES DA CONTA
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}