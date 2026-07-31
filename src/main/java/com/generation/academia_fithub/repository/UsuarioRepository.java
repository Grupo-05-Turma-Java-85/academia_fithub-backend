package com.generation.academia_fithub.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.generation.academia_fithub.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	Optional<Usuario> findByUsuario(String usuario);

}