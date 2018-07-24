package com.example.implementacionApiRest.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "COM_MENU")
public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(length = 9, nullable = false)
	private String menu;

	@Column(name="DES_MENU",length = 100, nullable = false)
	private String menuDesc;
	
	
//	@OneToMany(mappedBy="menu")
//	private List<Funcion> funciones= new ArrayList<>();


}
