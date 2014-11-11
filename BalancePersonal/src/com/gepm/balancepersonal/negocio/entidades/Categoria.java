package com.gepm.balancepersonal.negocio.entidades;

import com.ernesto.perez.balancepersonal.datos.entidades.CategoriaD;

public class Categoria {
	private Long id;
	private String nombre;
	private long icResImagen;

	public Categoria(String nombre, long icResImagen) {
		super();
		this.nombre = nombre;
		this.icResImagen = icResImagen;
	}

	public CategoriaD toCategoriaD() {
		return new CategoriaD(getId(), getNombre(),
				getIcResImagen());
	}

	public Categoria(Long id, String nombre, long icResImagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.icResImagen = icResImagen;
	}

	public Categoria(CategoriaD cated) {
		super();
		this.id = cated.getId();
		this.nombre = cated.getNombre();
		this.icResImagen = cated.getResImagen();
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

}
