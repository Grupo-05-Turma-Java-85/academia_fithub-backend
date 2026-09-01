package com.generation.academia_fithub.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_exercicios")
@JsonPropertyOrder({ "id", "nome", "equipamento", "foto", "execucaoTecnica", "categoria" })
public class Exercicio {

	@Id // PRIMARY KEY
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(min = 5, max = 255, message = "O atributo nome deve ter no mínimo 5 e no máximo 255 caracteres.")
	@Column(length = 255)
	private String nome;

	@NotBlank(message = "O atributo equipamento é obrigatório!")
	@Size(min = 5, max = 255, message = "O atributo equipamento deve ter no mínimo 5 e no máximo 255 caracteres.")
	@Column(length = 255)
	private String equipamento;
	
	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
	@Column(length = 5000)
	private String foto;

	//PASSO A PASSO DE EXECUÇÃO (texto longo, por isso @Lob)
	@Lob
	@Column(columnDefinition = "TEXT")
	private String execucaoTecnica;
	
	@ManyToOne
	@JsonIgnoreProperties("exercicio")
	private Categoria categoria;

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

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getExecucaoTecnica() {
		return execucaoTecnica;
	}

	public void setExecucaoTecnica(String execucaoTecnica) {
		this.execucaoTecnica = execucaoTecnica;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}