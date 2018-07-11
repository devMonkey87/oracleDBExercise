package com.example.implementacionApiRest.view.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.example.implementacionApiRest.entity.Rol;


public class RoleList {
	
	
	@XmlElement(name="role")
	public List<Rol> roles;

	public RoleList() {}


	public RoleList(List<Rol> roles) {
		this.roles = roles;
	}

	public List<Rol> getRoles() {
		return roles;
	}

}
