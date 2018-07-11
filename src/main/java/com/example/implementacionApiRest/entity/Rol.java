package com.example.implementacionApiRest.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@Table(name = "COM_ROLE")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "role")

public class Rol implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(length = 100, nullable = false)
	private String role;
	@Column(name = "DES_ROLE", length = 100, nullable = false)

	private String roleDescription;

	// @Column(length = 30, nullable = false)
	// private String usuins;
	// @Column(nullable = false)
	//
	// private Date tmsins;
	// @Column(length = 30)
	// private String usumod;
	// private Date tmsmod;

	// @ManyToMany(fetch=FetchType.EAGER)
	@ManyToMany
	@JoinTable(name = "COM_ROLE_USUARIO", joinColumns = @JoinColumn(name = "role"), inverseJoinColumns = @JoinColumn(name = "usuario"))
	// @JsonIgnoreProperties("usuario")

	@JsonManagedReference

	private List<Usuario> usuarios = new ArrayList<>();

	@OneToMany(mappedBy = "role")
	@JsonManagedReference
	private List<Permiso> permisos = new ArrayList<>();

}
