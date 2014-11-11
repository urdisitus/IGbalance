package com.gepm.balancepersonal.negocio.entidades;

import com.ernesto.perez.balancepersonal.datos.entidades.BancoD;

public class Banco {
	private Long id;
	private String nombre;
	private long icResImagen;
	private int tipo;

	public Banco(String nombre, long icResImagen, int tipo) {
		super();
		this.nombre = nombre;
		this.icResImagen = icResImagen;
		this.tipo = tipo;
	}
	
	public Banco(BancoD banco) {
		super();
		this.id = banco.getId();
		this.nombre = banco.getNombre();
		this.icResImagen = banco.getResImagen();
		this.tipo = banco.getTipo();
	}

	public Banco(Long id, String nombre, long icResImagen, int tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.icResImagen = icResImagen;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getIcResImagen() {
		return icResImagen;
	}

	public void setIcResImagen(long icResImagen) {
		this.icResImagen = icResImagen;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
