package com.example.implementacionApiRest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.implementacionApiRest.service.UsuarioService;

@SpringBootApplication
@ComponentScan({ "com.example" })
public class PruebaOracleDbApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("usuarioServ")
	UsuarioService usuarioService;


	public static void main(String[] args) {

		SpringApplication.run(PruebaOracleDbApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


	}
}
