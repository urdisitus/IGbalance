package com.gepm.balancepersonal.negocio.entidades;

import android.content.Context;
import com.gepm.balancepersonal.R;
import com.gepm.balancepersonal.negocio.OrigenFinancieroBL;

public class Efectivo extends OrigenFinanciero {
	private OrigenFinancieroBL origenFinancieroBL;

	public Efectivo(Context context) {
		super(1L, "Efectivo", 0, R.drawable.money);
		origenFinancieroBL = new OrigenFinancieroBL(context);
		OrigenFinanciero orr = origenFinancieroBL.getOrigenFinanciero(1L);
		if (orr != null) {
			setSaldo(orr.getSaldo());
		}
	}

	@Override
	public void setIcoResImagen(long icoResImagen) {
		throw new Error("No es posible cambiar el nombre a Efectivo");
	}

	@Override
	public void setId(Long id) {
		throw new Error("No es posible cambiar el nombre a Efectivo");
	}


	@Override
	public void setNombre(String nombre) {
		throw new Error("No es posible cambiar el nombre a Efectivo");
	}

}
