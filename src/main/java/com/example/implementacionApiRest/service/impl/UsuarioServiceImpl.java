package com.example.implementacionApiRest.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.implementacionApiRest.entity.Rol;
import com.example.implementacionApiRest.entity.Usuario;
import com.example.implementacionApiRest.repository.IUsuarioRepository;
import com.example.implementacionApiRest.service.UsuarioService;

import java.util.List;




@Service
@Primary
@Qualifier("usuarioServ")
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired IUsuarioRepository usuarioRepository;
	
	@Transactional
	public  Optional<Usuario> getUsuarioById(String id) throws Exception {
		
		Optional<Usuario> usuario =  usuarioRepository.findById(id);
		
		if(!usuario.isPresent())
		{
			throw new Exception("------------No hay usuario con ese id-------"+id, null);
		}
		return usuario;
		
	
	}
	
	@Transactional
	public List<Usuario> getAllusuarios(){

		List<Usuario>  usuarios=usuarioRepository.findAll();

		return usuarios;
	}

	public List<Usuario> findByNombreContainsOrApellidosContainsAllIgnoreCase(String descriptionPart,
			String titlePart) {

		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		return usuarios;
	}

	public Optional<Usuario> findUsuarioById(String userID) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(userID);
		return usuario;
	}
	
	
	
	
	

}
