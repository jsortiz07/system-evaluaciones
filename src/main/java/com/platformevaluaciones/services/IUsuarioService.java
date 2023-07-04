package com.platformevaluaciones.services;

import java.util.Optional;
import java.util.Set;

import com.platformevaluaciones.Entity.Usuario;
import com.platformevaluaciones.Entity.UsuarioRol;


public interface IUsuarioService {

	public Usuario saveUser(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
	
	public Usuario obtenerUser(String username);
	
	public void  deleteUser(Long userId);
}
