package com.example.implementacionApiRest.controller;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.implementacionApiRest.entity.Permiso;
import com.example.implementacionApiRest.entity.Rol;
import com.example.implementacionApiRest.entity.Usuario;
import com.example.implementacionApiRest.security.SecurityConfig;
import com.example.implementacionApiRest.service.FuncionService;
import com.example.implementacionApiRest.service.PermisoService;
import com.example.implementacionApiRest.service.RolService;
import com.example.implementacionApiRest.service.UsuarioService;
import com.example.implementacionApiRest.view.xml.FuncionList;
import com.example.implementacionApiRest.view.xml.PermisoList;
import com.example.implementacionApiRest.view.xml.RoleList;
import com.example.implementacionApiRest.view.xml.UsuarioList;


@RestController
@RequestMapping("/api")

public class mainController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(mainController.class.getName());

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	RolService rolService;

	@Autowired
	PermisoService permisoService;

	@Autowired
	FuncionService funcionService;

	@Autowired
	private SecurityConfig securityConf;

	@RequestMapping(value = { "/user" }, method = RequestMethod.GET)

	public UsuarioList listar() {

		return new UsuarioList(usuarioService.getAllusuarios());

		//
		// //logger.info("PROBANDO LOGGER ->
		// {}",usuarioService.getUsuarioById("manuel"));
		// logger.info("PROBANDO LOGGER -> {}",usuarioService.getUsuarioById("BBRAGL"));
		//
		// logger.info("PROBANDO LOGGER -> {}",usuarioService.getAllusuarios());

	}

	@RequestMapping(value = { "/roles" }, method = RequestMethod.GET)

	public RoleList listarRoles() {

		return new RoleList(rolService.getAllRoles());

	}

	@RequestMapping(value = "/rolesRest", method = RequestMethod.GET)

	public @ResponseBody List<Rol> listarRolesRest() {

		List<Rol> list = rolService.getAllRoles();


		logger.warn("ROLES EXISTENTES EN GSA -> {}", rolService.getAllRoles());

		return rolService.getAllRoles();

	}

	@RequestMapping(value = "/rolesRest/{id}", method = RequestMethod.GET)

	public @ResponseBody Optional<Rol> getRolById(@PathVariable("id") String id) throws Exception {

		return rolService.getRoleById(id);

	}

	@RequestMapping(value = "/usersRest", method = RequestMethod.GET)

	public @ResponseBody List<Usuario> listarUsuariosRest() {

		return usuarioService.getAllusuarios();

	}

	// No funciona ya que el método permisosPorRol(rol) que
	@GetMapping("/permisos/{id}")
	@ResponseBody
	public Optional<Permiso> permisoPorRol(@PathVariable("id") String rol) {

		return permisoService.permisosPorRol(rol);

	}
	//
	// @RequestMapping(value = "/permisosRol" , method = RequestMethod.GET)
	//
	// public @ResponseBody List<Permiso> permisosByRolRest() {
	//
	// return permisoService.getAllPermisosByRol();
	//
	// }

	@RequestMapping(value = { "/permisos" }, method = RequestMethod.GET)

	public PermisoList listarPermisos() {

		return new PermisoList(permisoService.getAllPermisos());

	}

	@RequestMapping(value = { "/funciones" }, method = RequestMethod.GET)

	public FuncionList listarFunciones() {

		return new FuncionList(funcionService.getAllFunciones());

	}

	@RequestMapping(value = { "/user2" }, method = RequestMethod.GET)

	public List<Usuario> lista2() {
		return usuarioService.getAllusuarios();

	}

	// No funciona bien, devuelve todos los usuarios indistintamente del apellido
	// o el nombre
	@RequestMapping(value = { "/filtro" }, method = RequestMethod.GET)

	public List<Usuario> listaFiltrada() {
		return usuarioService.findByNombreContainsOrApellidosContainsAllIgnoreCase("demo", "gallardo");

	}

	// endpoint que permite devolver un objeto Rol identificado por
	// su ID pasado por parametro en el request
	// Debido a las relaciones mapeadas, además devuelve todos los usuarios
	// asociados
	// a este rol en formato JSON
	// algunos roles son: R_DESGSA1_DEMO, R_DESGSA1_PROVA, R_DESGSA1_DEMORES
	@RequestMapping(value = { "/filtroRolID/{rolId}" }, method = RequestMethod.GET)
	@ResponseBody
	public Optional<Rol> filtroRol(@PathVariable("rolId") String rolId) {
		return rolService.findRolById(rolId);

	}

	// Igual que el anterior pero de USUARIOS
	// algunos usuarios son: BBRJPO, DEMOGENCAT, BBRPGD, DESGSA1, BBRJGP
	@RequestMapping(value = { "/filtroUsuarioID/{userID}" }, method = RequestMethod.GET)
	@ResponseBody
	public Optional<Usuario> filtroUser(@PathVariable("userID") String userID) {
		return usuarioService.findUsuarioById(userID);

	}
	

	
	
	  @GetMapping("/ldap")
		public String index(Authentication authentication) {

			
			try {

				if (logger.isInfoEnabled()) {
					logger.error("PRINCIPAL: " + authentication.getPrincipal());
					logger.warn("AUTORIDADES: "+ authentication.getAuthorities());
					logger.error("DETALLES: "+ authentication.getDetails());
					
					UserDetails userDetails = (UserDetails) authentication.getPrincipal();
					logger.warn("User has authorities: " + userDetails.getAuthorities());

				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return "Welcome to the home page!";

		}
	

	
	
	
}
