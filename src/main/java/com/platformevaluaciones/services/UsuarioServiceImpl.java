package com.platformevaluaciones.services;

import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platformevaluaciones.Entity.Usuario;
import com.platformevaluaciones.Entity.UsuarioRol;
import com.platformevaluaciones.repositorys.IRolRepository;
import com.platformevaluaciones.repositorys.IUsuarioRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	IRolRepository rolRepository;
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	

	@Override
	public Usuario saveUser(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
		Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
		
		if (usuarioLocal != null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya esta presente");
		}else {
			for (UsuarioRol usuarioRol : usuarioRoles) {
				rolRepository.save(usuarioRol.getRol());
			}
			
			usuario.getUsuarioRoles().addAll(usuarioRoles);
			usuarioLocal = usuarioRepository.save(usuario);
		}
		
		return usuarioLocal;
	}


	@Override
	public Usuario obtenerUser(String username) {
		return usuarioRepository.findByUsername(username);
	}


	@Override
	public void deleteUser(Long userId) {
		usuarioRepository.deleteById(userId);
		
	}

}
