package com.unab.seguridad_33.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


@Entity
@Table(name = "servicios")

public class Servicios implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "descripcion", nullable = false)
	private String Descripcion;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
}
