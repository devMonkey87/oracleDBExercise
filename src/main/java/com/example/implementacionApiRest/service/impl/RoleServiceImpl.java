package com.example.implementacionApiRest.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.implementacionApiRest.entity.Rol;
import com.example.implementacionApiRest.repository.IRolRepository;
import com.example.implementacionApiRest.service.RolService;
import java.util.List;




@Service
@Qualifier("roleServ")
public class RoleServiceImpl implements RolService {

	@Autowired IRolRepository rolRepository;
	
	@Transactional
	@Override
	public  Optional<Rol> getRoleById(String id) throws Exception {
		
		Optional<Rol> rol =  rolRepository.findById(id);
		
		if(!rol.isPresent())
		{
			throw new Exception("------------No hay rol con ese id-------"+id, null);
		}
		return rol;
		
	
	}
	
	@Transactional
	public List<Rol> getAllRoles(){

		List<Rol>  roles=rolRepository.findAll();

		return roles;
	}
// intento de crear queries por parametro
//	@Override
//	public Rol findRoleById(String idRol) {
//		
//		Optional<Rol> rol = rolRepository.findById(idRol)
//		
//		return rol;
//	}

	@Override
	public Optional<Rol> findRolById(String id) {
		
		
		Optional<Rol> rolObject = rolRepository.findById(id);
		return rolObject;
	}
	

	

	
	
	
	

}
