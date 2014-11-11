package com.gepm.balancepersonal.negocio.entidades;

public class Adjunto {
	private Long id;
	private String nota;
	private Imagen captura;

	public Adjunto(Long id, String nota, Imagen captura) {
		super();
		this.id = id;
		this.nota = nota;
		this.captura = captura;
	}

	public Adjunto(Long id) {
		super();
		this.id = id;
	}

	public Adjunto(String nota, Imagen captura) {
		super();
		this.nota = nota;
		this.captura = captura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public Imagen getCaptura() {
		return captura;
	}

	public void setCaptura(Imagen captura) {
		this.captura = captura;
	}

}
