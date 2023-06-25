package com.platformevaluaciones.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platformevaluaciones.Entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	public Usuario findByUsername(String username);
}
