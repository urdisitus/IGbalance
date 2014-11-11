package com.gepm.balancepersonal.negocio;

import java.util.Calendar;

import android.content.Context;

import com.ernesto.perez.balancepersonal.daos.DaoSession;
import com.ernesto.perez.balancepersonal.daos.OrigenFinancieroDDao;
import com.ernesto.perez.balancepersonal.datos.entidades.OrigenFinancieroD;
import com.gepm.balancepersonal.negocio.entidades.Movimiento;
import com.gepm.balancepersonal.negocio.entidades.OrigenFinanciero;
import com.gepm.balancepersonal.negocio.entidades.TipoMovimiento;

public class OrigenFinancieroBL extends ObjetoBL<OrigenFinancieroDDao> {

	public OrigenFinancieroBL(Context context) {
		super(context);
	}

	@Override
	protected OrigenFinancieroDDao getDao(DaoSession daoSession) {
		return daoSession.getOrigenFinancieroDDao();
	}

	public long insertar(final double latitud, final double longitud,
			final OrigenFinanciero origenF) {

		OrigenFinancieroD or = new OrigenFinancieroD();
		or.setNombre(origenF.getNombre());
		or.setResImagen(origenF.getIcoResImagen());
		or.setSaldo(0);
		getDefaultDaoSession().getOrigenFinancieroDDao().insert(or);
		origenF.setId(or.getId());
		if (origenF.getSaldo() > 0) {
			Movimiento mov = new Movimiento(latitud, longitud, Calendar
					.getInstance().getTime(), origenF.getSaldo(),
					CategoriaBL.saldoInicial, origenF, TipoMovimiento.INGRESO);
			MovimientoBL movBL = new MovimientoBL(context);
			movBL.insertarInTransaccion(mov);
		}
		return or.getId();
	}

	public OrigenFinanciero getOrigenFinanciero(long id) {
		OrigenFinancieroD origen = getDefaultDao().load(id);
		if (origen != null) {
			return new OrigenFinanciero(origen);
		}
		return null;
	}
}
