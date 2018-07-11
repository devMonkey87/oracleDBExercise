package com.example.implementacionApiRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.implementacionApiRest.entity.Usuario;
@Repository

public interface IUsuarioRepository extends JpaRepository<Usuario, String> {
	
	

}
