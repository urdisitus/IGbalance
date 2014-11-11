package com.gepm.balancepersonal.negocio.entidades;

public class Cuenta extends OrigenFinanciero {
	private String nroCuenta;
	private Banco banco;

	public Cuenta(double saldo, String nroCuenta, Banco banco) {
		super(banco.getNombre(), saldo, banco.getIcResImagen());
		this.nroCuenta = nroCuenta;
		this.banco = banco;
	}

	public Banco getBanco() {
		return banco;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

}
