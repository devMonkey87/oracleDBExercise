package com.example.implementacionApiRest.service;

import java.util.List;
import java.util.Optional;

import com.example.implementacionApiRest.entity.Funcion;
import com.example.implementacionApiRest.entity.Usuario;

public interface FuncionService {

	Optional<Funcion> getFuncionById(String id) throws Exception;
	
	
	 List<Funcion> getAllFunciones();

}
