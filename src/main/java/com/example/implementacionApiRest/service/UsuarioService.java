package com.example.implementacionApiRest.service;

import java.util.List;
import java.util.Optional;

import com.example.implementacionApiRest.entity.Rol;
import com.example.implementacionApiRest.entity.Usuario;

public interface UsuarioService {

	Optional<Usuario> getUsuarioById(String usuario) throws Exception;

	List<Usuario> getAllusuarios();

	List<Usuario> findByNombreContainsOrApellidosContainsAllIgnoreCase(String descriptionPart, String titlePart);

}
