package com.gepm.balancepersonal.negocio.entidades;

import java.util.Date;

public class Ingreso extends Movimiento {

	public Ingreso(String concepto, double latitud, double longitud,
			Date fecha, double importe, Categoria categoria,
			OrigenFinanciero origenFinanciero, TipoMovimiento tipoMovimiento) {
		super(concepto, latitud, longitud, fecha, importe, categoria,
				origenFinanciero, TipoMovimiento.INGRESO);
	}

	public Ingreso(Long id, String concepto, double latitud, double longitud,
			Date fecha, double importe, Categoria categoria,
			OrigenFinanciero origenFinanciero, TipoMovimiento tipoMovimiento,
			AnulacionMovimiento anulacionMovimiento) {
		super(id, concepto, latitud, longitud, fecha, importe, categoria,
				origenFinanciero, TipoMovimiento.INGRESO, anulacionMovimiento);
	}

}
