package com.example.implementacionApiRest.view.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.example.implementacionApiRest.entity.Funcion;


public class FuncionList {
	
	
	@XmlElement(name="funcion")
	public List<Funcion> funciones;

	public FuncionList() {}


	public FuncionList(List<Funcion> funciones) {
		this.funciones = funciones;
	}

	public List<Funcion> getFunciones() {
		return funciones;
	}

}
