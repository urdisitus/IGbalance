package com.gepm.balancepersonal.negocio.entidades;

import java.util.Date;

public class Gasto extends Movimiento {

	public Gasto(String concepto, double latitud, double longitud, Date fecha,
			double importe, Categoria categoria,
			OrigenFinanciero origenFinanciero, TipoMovimiento tipoMovimiento) {
		super(concepto, latitud, longitud, fecha, importe, categoria,
				origenFinanciero, TipoMovimiento.GASTO);
	}

	public Gasto(Long id, String concepto, double latitud, double longitud,
			Date fecha, Categoria categoria, double importe,
			OrigenFinanciero origenFinanciero, TipoMovimiento tipoMovimiento,
			AnulacionMovimiento anulacionMovimiento) {
		super(id, concepto, latitud, longitud, fecha, importe, categoria,
				origenFinanciero, TipoMovimiento.GASTO, anulacionMovimiento);
	}
}
