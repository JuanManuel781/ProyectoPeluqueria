package com.unab.seguridad_33.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
/*Estas dos anotaciones permiten no crear todos los metodos Getter y Setter*/

public class Usuarios implements Serializable{
	
	/* Esta linea de codigo sirve para sabeer en que version esta nuestra app */
	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "tipo_documento", nullable = false)
	private String Tipo_Documento;
	
	@Column(name = "numero_documento", nullable = false, unique = true)
	private Integer Numero_Documento;
	
	@Column(name = "nombre", nullable = false)
	private String Nombre;
	
	@Column(name = "apellido", nullable = false)
	private String Apellido;
	
	@Column(name = "correo", nullable = false)
	private String Correo;
	
	@Column(name = "celular", nullable = false)
	private Integer Celular;
	
	@Column(name = "usuario", nullable = false)
	private String Usuario;
	
	@Column(name = "contrasenia", nullable = false)
	private String Contrasenia;
	
	/*LLAVE FORANEA */
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "id_rol_usuario", nullable = false)
	private Roles IdRolUsuario;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getTipo_Documento() {
		return Tipo_Documento;
	}

	public void setTipo_Documento(String tipo_Documento) {
		Tipo_Documento = tipo_Documento;
	}

	public Integer getNumero_Documento() {
		return Numero_Documento;
	}

	public void setNumero_Documento(Integer numero_Documento) {
		Numero_Documento = numero_Documento;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public Integer getCelular() {
		return Celular;
	}

	public void setCelular(Integer celular) {
		Celular = celular;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getContrasenia() {
		return Contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}

	public Roles getIdRolUsuario() {
		return IdRolUsuario;
	}

	public void setIdRolUsuario(Roles idRolUsuario) {
		IdRolUsuario = idRolUsuario;
	}
}
