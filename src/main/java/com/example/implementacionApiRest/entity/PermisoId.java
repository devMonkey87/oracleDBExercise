package com.example.implementacionApiRest.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Embeddable
public class PermisoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "menu")
	private String menu;

	@Column(name = "funcion")
	private String funcion;

	@Column(name = "role")
	private String rol;

	public PermisoId() {
	}

	public PermisoId(String menu, String funcion, String rol) {
		this.menu = menu;
		this.funcion = funcion;
		this.rol = rol;
	}

	public String getMenu() {
		return menu;
	}

	public String getFuncion() {
		return funcion;
	}

	public String getRol() {
		return rol;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PermisoId))
			return false;
		PermisoId that = (PermisoId) o;
		return Objects.equals(getMenu(), that.getMenu()) && Objects.equals(getFuncion(), that.getFuncion())
				&& Objects.equals(getRol(), that.getRol());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getMenu(), getFuncion(), getRol());
	}
}
