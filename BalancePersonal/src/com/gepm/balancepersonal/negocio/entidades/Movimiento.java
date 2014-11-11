package com.gepm.balancepersonal.negocio.entidades;

import java.util.Date;

public class Movimiento {
	private Long id;
	private String concepto;
	private double latitud;
	private double longitud;
	private Date fecha;
	private double importe;
	private Categoria categoria;
	private OrigenFinanciero origenFinanciero;
	private TipoMovimiento tipoMovimiento;
	private AnulacionMovimiento anulacionMovimiento;
	private Adjunto adjunto;
	
	
	

	public Movimiento(String concepto, double latitud, double longitud,
			Date fecha, double importe, Categoria categoria,
			OrigenFinanciero origenFinanciero, TipoMovimiento tipoMovimiento) {
		super();
		this.concepto = concepto;
		this.latitud = latitud;
		this.importe = importe;
		this.longitud = longitud;
		this.fecha = fecha;
		this.categoria = categoria;
		this.origenFinanciero = origenFinanciero;
		this.tipoMovimiento = tipoMovimiento;
	}

	public Movimiento(double latitud, double longitud, Date fecha,
			double importe, Categoria categoria,
			OrigenFinanciero origenFinanciero, TipoMovimiento tipoMovimiento) {
		super();
		this.concepto = categoria.getNombre();
		this.latitud = latitud;
		this.importe = importe;
		this.longitud = longitud;
		this.fecha = fecha;
		this.categoria = categoria;
		this.origenFinanciero = origenFinanciero;
		this.tipoMovimiento = tipoMovimiento;
	}

	public void setAdjunto(Adjunto adjunto) {
		this.adjunto = adjunto;
	}

	public Adjunto getAdjunto() {
		return adjunto;
	}

	public Movimiento(Long id, String concepto, double latitud,
			double longitud, Date fecha, double importe, Categoria categoria,
			OrigenFinanciero origenFinanciero, TipoMovimiento tipoMovimiento,
			AnulacionMovimiento anulacionMovimiento) {
		super();
		this.id = id;
		this.concepto = concepto;
		this.latitud = latitud;
		this.longitud = longitud;
		this.fecha = fecha;
		this.importe = importe;
		this.categoria = categoria;
		this.origenFinanciero = origenFinanciero;
		this.tipoMovimiento = tipoMovimiento;
		this.anulacionMovimiento = anulacionMovimiento;
	}

	public Movimiento(Long id, String concepto, double latitud,
			double longitud, Date fecha, double importe, Categoria categoria,
			OrigenFinanciero origenFinanciero, TipoMovimiento tipoMovimiento) {
		super();
		this.id = id;
		this.concepto = concepto;
		this.latitud = latitud;
		this.longitud = longitud;
		this.fecha = fecha;
		this.importe = importe;
		this.categoria = categoria;
		this.origenFinanciero = origenFinanciero;
		this.tipoMovimiento = tipoMovimiento;
	}

	public Long getId() {
		return id;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public OrigenFinanciero getOrigenFinanciero() {
		return origenFinanciero;
	}

	public void setOrigenFinanciero(OrigenFinanciero origenFinanciero) {
		this.origenFinanciero = origenFinanciero;
	}

	public TipoMovimiento getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public AnulacionMovimiento getAnulacionMovimiento() {
		return anulacionMovimiento;
	}

	public void setAnulacionMovimiento(AnulacionMovimiento anulacionMovimiento) {
		this.anulacionMovimiento = anulacionMovimiento;
	}

}
