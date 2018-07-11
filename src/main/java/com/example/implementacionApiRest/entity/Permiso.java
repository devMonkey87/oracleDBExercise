package com.example.implementacionApiRest.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name = "COM_PERMISOS")
public class Permiso implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PermisoId permisoId;

	@ManyToOne
	@JoinColumn(name = "role",insertable = false, updatable = false)
	@JsonBackReference
	//@JsonIgnoreProperties("permisos")
	private Rol role;

	@ManyToOne
	@JsonBackReference
	@JoinColumns({

			@JoinColumn(name = "funcion", insertable = false, updatable = false),
			@JoinColumn(name = "menu", insertable = false, updatable = false)

	})
	private Funcion funcion;

	@Column(length = 100)
	private String usuins;
	@Column(length = 100)
	private String acceso;

	private Date tmsins;
	@Column(length = 100)
	private String usumod;

	private Date tmsmod;
}
