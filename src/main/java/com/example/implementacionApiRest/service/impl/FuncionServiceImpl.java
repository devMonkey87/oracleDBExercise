package com.example.implementacionApiRest.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.implementacionApiRest.entity.Funcion;
import com.example.implementacionApiRest.entity.Usuario;
import com.example.implementacionApiRest.repository.IFuncionRepository;
import com.example.implementacionApiRest.service.FuncionService;
import java.util.List;




@Service
@Qualifier("funcionServ")

public class FuncionServiceImpl implements FuncionService {

	@Autowired IFuncionRepository funcionRepository;
	
	@Transactional
	@Override
	public  Optional<Funcion> getFuncionById(String id) throws Exception {
		
		Optional<Funcion> funcion =  funcionRepository.findById(id);
		
		if(!funcion.isPresent())
		{
			throw new Exception("------------No hay funcion con ese id-------"+id, null);
		}
		return funcion;
		
	
	}
	
	@Transactional
	public List<Funcion> getAllFunciones(){

		List<Funcion>  funciones=funcionRepository.findAll();

		return funciones;
	}
	
	
	
	
	

}
