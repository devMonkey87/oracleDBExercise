package com.example.implementacionApiRest.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


	
	
	@Embeddable
	public class FuncionId implements Serializable {
	 
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Column(name = "menu")
	    private String menu;
	 
	    @Column(name = "funcion")
	    private String funcion;
	 
	    public FuncionId() {
	    }
	 
	    public FuncionId(String menu, String funcion) {
	        this.menu = menu;
	        this.funcion = funcion;
	    }
	 
	   
	 
	    public String getMenu() {
			return menu;
		}

		public String getFuncion() {
			return funcion;
		}

		@Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (!(o instanceof FuncionId)) return false;
	        FuncionId that = (FuncionId) o;
	        return Objects.equals(getMenu(), that.getMenu()) &&
	                Objects.equals(getFuncion(), that.getFuncion());
	    }
	 
	    @Override
	    public int hashCode() {
	        return Objects.hash(getMenu(), getFuncion());
	    }
	}
	


