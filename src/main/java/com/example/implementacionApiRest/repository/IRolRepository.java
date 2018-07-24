package com.example.implementacionApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.implementacionApiRest.entity.Rol;

public interface IRolRepository extends JpaRepository<Rol, String> {
	
	

}
