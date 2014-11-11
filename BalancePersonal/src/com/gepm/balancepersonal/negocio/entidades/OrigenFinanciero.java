package com.gepm.balancepersonal.negocio.entidades;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.ernesto.perez.balancepersonal.datos.entidades.OrigenFinancieroD;
import com.gepm.balancepersonal.negocio.MovimientoBL;

public class OrigenFinanciero {
	private Long id;
	private String nombre;
	private double saldo;
	private long icoResImagen;
	protected List<Movimiento> movimientos = new ArrayList<Movimiento>();
	private MovimientoBL movimientoBL;

	public OrigenFinanciero(String nombre, double saldo, long icoResImagen) {
		super();
		this.nombre = nombre;
		this.saldo = saldo;
		this.icoResImagen = icoResImagen;
	}

	public OrigenFinanciero(OrigenFinancieroD of) {
		super();
		this.id = of.getId();
		this.nombre = of.getNombre();
		this.saldo = of.getSaldo();
		this.icoResImagen = of.getResImagen();
	}

	public OrigenFinanciero(Long id, String nombre, double saldo,
			long icoResImagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
		this.icoResImagen = icoResImagen;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Movimiento> getMovimientos(Context context) {
		if (movimientoBL == null) {
			movimientoBL = new MovimientoBL(context);
		}
		movimientos = movimientoBL.getMovimientos(this, 5);
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public long getIcoResImagen() {
		return icoResImagen;
	}

	public void setIcoResImagen(long icoResImagen) {
		this.icoResImagen = icoResImagen;
	}

}
