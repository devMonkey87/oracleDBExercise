package com.example.implementacionApiRest.service;

import java.util.List;
import java.util.Optional;

import com.example.implementacionApiRest.entity.Rol;

public interface RolService {

	Optional<Rol> getRoleById(String id) throws Exception;

	List<Rol> getAllRoles();
	
	Optional<Rol> findRolById(String id);


}
