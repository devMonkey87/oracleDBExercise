package com.example.implementacionApiRest.service;

import java.util.List;
import java.util.Optional;

import com.example.implementacionApiRest.entity.Permiso;

public interface PermisoService {

	Optional<Permiso> getPermisoById(String id) throws Exception;
	
	public List<Permiso> getAllPermisos();

	Optional<Permiso> permisosPorRol(String rol);
	
//	public List<Permiso> getAllPermisosByRol();

}
