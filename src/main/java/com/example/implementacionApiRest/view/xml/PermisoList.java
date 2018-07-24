package com.example.implementacionApiRest.view.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.example.implementacionApiRest.entity.Permiso;


public class PermisoList {
	
	
	@XmlElement(name="permiso")
	public List<Permiso> permisos;

	public PermisoList() {}


	public PermisoList(List<Permiso> permisos) {
		this.permisos = permisos;
	}

	public List<Permiso> getPermisos() {
		return permisos;
	}

}
