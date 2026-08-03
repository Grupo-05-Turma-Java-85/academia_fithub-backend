package com.generation.academia_fithub.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@JsonPropertyOrder({ "id", "foto", "nome", "peso", "altura", "usuario", "senha"})

@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	@Id //PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O atributo nome é obrigatório!")
	@Column(length = 255)
	private String nome;

	@Schema(example = "email@email.com.br")
	@NotBlank(message = "O atributo usuário é obrigatório!")
	@Email(message = "O atributo usuário deve ser um email válido!")
	@Column(length = 255)
	private String usuario;

	@NotBlank(message = "O atributo senha é obrigatório!")
	@Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres.")
	@Column(length = 255)
	private String senha;

	@Size(max = 500, message = "O link da foto não pode ser maior do que 500 caracteres")
	@Column(length = 500)
	private String foto;
	
	@NotNull(message = "O atributo peso é obrigatório!")
	@Positive(message= "O atributo peso deve ser maior que zero!")
	@Column(nullable= false)
	private Double peso;

	@NotNull(message = "O atributo altura é obrigatório!")
	@Positive(message= "O atributo altura deve ser maior que zero!")
	@Column(nullable= false)
	private Double altura;
	
	
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
	
	//CALCULAR IMC
	public Double calcularIMC() {
		 return peso/(altura*altura);
	}
	
}

