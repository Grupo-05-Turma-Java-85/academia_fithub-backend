package com.generation.academia_fithub.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "O nome da categoria não pode estar vazio")
	@Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
	@Column(length = 50)
	private String nome;

	@NotBlank(message = "A descrição não pode estar vazia")
	@Size(min = 5, max = 80, message = "A descrição deve ter entre 5 e 80 caracteres")
	@Column(length = 80)
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Exercicio> exercicio;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Exercicio> getExercicio() {
		return exercicio;
	}

	public void setExercicio(List<Exercicio> exercicio) {
		this.exercicio = exercicio;
	}

}
