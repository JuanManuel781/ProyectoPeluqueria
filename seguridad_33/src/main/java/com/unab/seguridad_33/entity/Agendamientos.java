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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agendamientos")
@Getter
@Setter
public class Agendamientos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Integer Id;
	
	@Column(name = "fecha", nullable = false)
	private String Fecha;
	
	@Column(name = "hora", nullable = false)
	private String Hora;
	
	/* LLAVE FORANIA USUARIO */ 
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuarios UsuarioId;
	
	/* LLAVE FORANEA DE SERVICIOS */ 
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "servicios_id", nullable = false)
	private Servicios ServiciosId;
	
	/* LLAVE FORNAEA DE TIPOS PAGOS */
	@ManyToOne(fetch = FetchType.EAGER, optional=false)
	@JoinColumn(name = "tipo_pago", nullable = false)
	private TiposPagos TipoPago;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public Usuarios getUsuarioId() {
		return UsuarioId;
	}

	public void setUsuarioId(Usuarios usuarioId) {
		UsuarioId = usuarioId;
	}

	public Servicios getServiciosId() {
		return ServiciosId;
	}

	public void setServiciosId(Servicios serviciosId) {
		ServiciosId = serviciosId;
	}

	public TiposPagos getTipoPago() {
		return TipoPago;
	}

	public void setTipoPago(TiposPagos tipoPago) {
		TipoPago = tipoPago;
	}
	
	
	
	
	

}
