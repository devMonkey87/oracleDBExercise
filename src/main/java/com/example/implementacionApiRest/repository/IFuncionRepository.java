package com.example.implementacionApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.implementacionApiRest.entity.Funcion;

public interface IFuncionRepository extends JpaRepository<Funcion, String> {
	
	

}
