package com.gepm.balancepersonal.negocio.entidades;

public class Imagen {

	private Long id;
	private String direccionFisica;
	private int tipoImagen;
	private String nombre;

	public Imagen(String direccionFisica, int tipoImagen,
			String nombre, java.util.Date fechaModificacion) {
		this.direccionFisica = direccionFisica;
		this.tipoImagen = tipoImagen;
		this.nombre = nombre;
	}

	public Imagen(Long id, String direccionFisica, int tipoImagen,
			String nombre, java.util.Date fechaModificacion) {
		this.id = id;
		this.direccionFisica = direccionFisica;
		this.tipoImagen = tipoImagen;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccionFisica() {
		return direccionFisica;
	}

	public void setDireccionFisica(String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}

	public int getTipoImagen() {
		return tipoImagen;
	}

	public void setTipoImagen(int tipoImagen) {
		this.tipoImagen = tipoImagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
