package com.gepm.balancepersonal.negocio.entidades;

import java.util.Date;

public class AnulacionMovimiento {
	private Long id;
	private java.util.Date fechaHora;
	private String motivo;

	public AnulacionMovimiento(Long id, Date fechaHora, String motivo) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.motivo = motivo;
	}
	
	public AnulacionMovimiento(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public java.util.Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(java.util.Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

}
