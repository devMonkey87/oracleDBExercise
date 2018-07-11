package com.example.implementacionApiRest;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.implementacionApiRest.entity.Rol;
import com.example.implementacionApiRest.service.UsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaOracleDbApplicationTests {

	@Autowired UsuarioService usuarioServ;
	
	@Autowired EntityManager em;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	
	@Test
	public void contextLoads() {
	}
	
	
	@Test
	public void muestraTodo() {
		
		usuarioServ.getAllusuarios();
		

	}
	
	@Test
	@Transactional
	public void obtieneRolesyUsuarios() {
		//Rol rol = em.find(Rol.class,"R_DESGSA1");
	
		//logger.info("******  usuario -> {}",rol.getUsuarios());

	}
	
	



}
