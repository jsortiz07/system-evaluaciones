package com.platformevaluaciones.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platformevaluaciones.Entity.Rol;
import com.platformevaluaciones.Entity.Usuario;
import com.platformevaluaciones.Entity.UsuarioRol;
import com.platformevaluaciones.services.IUsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
	
	@Autowired
	IUsuarioService usuarioService;
	
	@PostMapping("/")
	public Usuario saveUser(@RequestBody Usuario usuario)throws Exception{
		
		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		usuario.setPerfil("default.png");
		Rol rol = new Rol();
		rol.setRolId(2L);
		rol.setNombre("NORMAL");
		
		
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setUsuario(usuario);
		usuarioRol.setRol(rol);
		usuarioRoles.add(usuarioRol);
		
		return usuarioService.saveUser(usuario, usuarioRoles);
	}
	
	@GetMapping("/{username}")
	public Usuario obtenerUser(@PathVariable("username") String username) {
		
		return usuarioService.obtenerUser(username);
		
	}
		
	@DeleteMapping("/{usuarioId}")
	public void deleteUser(@PathVariable("usuarioId") Long usuarioId) {
		usuarioService.deleteUser(usuarioId);
	}
		
	}
	
	
	
	


