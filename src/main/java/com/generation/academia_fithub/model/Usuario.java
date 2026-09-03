package com.generation.academia_fithub.model;

import java.time.LocalDate;
import java.time.Period;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@JsonPropertyOrder({ "id", "foto", "nome", "peso", "altura", "dataNascimento", "nivel", "frequenciaSemanal", "usuario", "senha", "treinoGerado", "tipoUsuario" })

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

	//CAMPOS NOVOS - PERFIL DE TREINO
	//São opcionais no cadastro (nullable) porque, seguindo o fluxo do design,
	//só são preenchidos depois, na tela "Setup Your Workout" (via PUT /usuarios/atualizar)

	@Schema(example = "2000-05-20")
	@Past(message = "A data de nascimento deve estar no passado!")
	@Column(nullable = true)
	private LocalDate dataNascimento;

	@Schema(example = "INICIANTE")
	@Size(max = 50, message = "O atributo nível não pode ter mais que 50 caracteres")
	@Column(length = 50, nullable = true)
	private String nivel; // INICIANTE | INTERMEDIARIO | AVANCADO

	@Positive(message = "O atributo frequência semanal deve ser maior que zero!")
	@Column(nullable = true)
	private Integer frequenciaSemanal; // dias por semana (1 a 7)

	//TREINO GERADO EM FORMATO JSON (STRING)
	//@Lob evita a necessidade de criar uma entidade/tabela nova para armazenar
	//a rotina montada (dias, exercícios escolhidos, séries e repetições sugeridas)
	@Lob
	@Column(columnDefinition = "TEXT", nullable = true)
	private String treinoGerado;

	@Min(value = 1, message = "O tipo de usuário deve ser 1 ou 2")
	@Max(value = 2, message = "O tipo de usuário deve ser 1 ou 2")
	@NotNull
	private Integer tipoUsuario;

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

	public String getTreinoGerado() {
		return treinoGerado;
	}
	public void setTreinoGerado(String treinoGerado) {
		this.treinoGerado = treinoGerado;
	}
	
	public Integer getTipoUsuario() {
	    return tipoUsuario;
	}
	public void setTipoUsuario(Integer tipoUsuario) {
	    this.tipoUsuario = tipoUsuario;
	}

	//CALCULAR IMC
	public Double calcularIMC() {
		 return peso/(altura*altura);
	}

	//CALCULAR IDADE A PARTIR DA DATA DE NASCIMENTO
	public Integer calcularIdade() {
		if (dataNascimento == null) {
			return null;
		}
		return Period.between(dataNascimento, LocalDate.now()).getYears();
	}
	
	
}
