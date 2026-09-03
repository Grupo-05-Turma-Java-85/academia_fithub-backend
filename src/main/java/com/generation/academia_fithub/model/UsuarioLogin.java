package com.generation.academia_fithub.model;

import java.time.LocalDate;

public class UsuarioLogin {//DATA TRANSFER OBJECT

	private Long id;
	private String nome;
	private String usuario;
	private String senha;
	private String foto;
	private Double peso;
	private Double altura;
	private LocalDate dataNascimento;
	private String nivel;
	private Integer frequenciaSemanal;
	private String token;

	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Double getAltura() {
		return altura;
	}
	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Integer getFrequenciaSemanal() {
		return frequenciaSemanal;
	}
	public void setFrequenciaSemanal(Integer frequenciaSemanal) {
		this.frequenciaSemanal = frequenciaSemanal;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}

}
