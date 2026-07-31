package com.generation.academia_fithub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.academia_fithub.model.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long>{

	public List<Exercicio> findAllByNomeContainingIgnoreCase(String nome);

}
