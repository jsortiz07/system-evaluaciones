package com.platformevaluaciones.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.platformevaluaciones.Entity.Usuario;
import com.platformevaluaciones.repositorys.IUsuarioRepository;


@Service
public class UserDatailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = this.usuarioRepository.findByUsername(username);
			
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		return usuario;
	}

}
