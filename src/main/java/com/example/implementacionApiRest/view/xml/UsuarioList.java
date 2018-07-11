package com.example.implementacionApiRest.view.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.example.implementacionApiRest.entity.Usuario;


public class UsuarioList {
	
	
	@XmlElement(name="usuario")
	public List<Usuario> usuarios;

	public UsuarioList() {}


	public UsuarioList(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

}
