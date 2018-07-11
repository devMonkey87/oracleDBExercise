package com.example.implementacionApiRest.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.implementacionApiRest.entity.Permiso;
import com.example.implementacionApiRest.repository.IPermisoRepository;
import com.example.implementacionApiRest.service.PermisoService;
import java.util.List;

@Service
@Qualifier("permisoServ")

public class PermisoServiceImpl implements PermisoService {

	@Autowired
	IPermisoRepository permisoRepository;

	@Transactional
	@Override
	public Optional<Permiso> getPermisoById(String id) throws Exception {

		Optional<Permiso> permiso = permisoRepository.findById(id);

		if (!permiso.isPresent()) {
			throw new Exception("------------No hay permiso con ese id-------" + id, null);
		}
		return permiso;

	}

	@Transactional
	public List<Permiso> getAllPermisos() {

		List<Permiso> permisos = permisoRepository.findAll();

		return permisos;
	}

	@Override
	@Transactional
	public Optional<Permiso> permisosPorRol(String rol) {

		Optional<Permiso> permisos = permisoRepository.findById(rol);

		return permisos;
	}
//
//	@Override
//	@Transactional
//	public List<Permiso> getAllPermisosByRol() {
//		
//		List<Permiso> permisos = permisoRepository.findByRol();
//
//		return permisos;
//	
//	}

}
