package com.example.implementacionApiRest.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "COM_FUNCIONES")
public class Funcion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FuncionId id;


	
	
	@ManyToOne
	@JoinColumn(name = "menu",insertable = false, updatable = false)
	@JsonIgnoreProperties("permisos")
	private Menu menu;

	
	@OneToMany(mappedBy = "funcion")
	@JsonManagedReference
	private List<Permiso> permisos = new ArrayList<>();

	@Column(length = 1)
	private String tipo;

	@Column(name = "DES_FUNCION", length = 100)
	private String functionDescription;

//	@Column(length = 30)
//	private String usuins;
//
//	private Date tmsins;
//
//	@Column(length = 30, nullable = true)
//	private String usumod;
//	@Column(length = 1, nullable = true)
//
//	private Date tmsmod;

}
