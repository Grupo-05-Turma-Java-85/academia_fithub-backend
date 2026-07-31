package com.generation.academia_fithub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.academia_fithub.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	public List<Categoria> findAllByNomeContainingIgnoreCase(String nome);
}
