package com.gepm.balancepersonal.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import android.content.Context;

import com.ernesto.perez.balancepersonal.daos.CuentaDDao;
import com.ernesto.perez.balancepersonal.daos.DaoSession;
import com.ernesto.perez.balancepersonal.datos.entidades.CuentaD;
import com.gepm.balancepersonal.negocio.entidades.Banco;
import com.gepm.balancepersonal.negocio.entidades.Cuenta;
import com.gepm.balancepersonal.negocio.entidades.OrigenFinanciero;

public class CuentaBL extends ObjetoBL<CuentaDDao> {

	public CuentaBL(Context context) {
		super(context);
	}

	@Override
	protected CuentaDDao getDao(DaoSession daoSession) {
		return daoSession.getCuentaDDao();
	}

	public long insertar(final double latitud, final double longitud,
			final Cuenta cuenta) throws Exception {
		return getDefaultDaoSession().callInTx(new Callable<Long>() {
			@Override
			public Long call() throws Exception {

				OrigenFinancieroBL orfBL = new OrigenFinancieroBL(context);
				long idOrigenFinanciero = orfBL.insertar(latitud, longitud,
						cuenta);
				CuentaD cuentaD = new CuentaD();
				cuentaD.setIdOrigenFinanciero(idOrigenFinanciero);
				cuentaD.setNroCuenta(cuenta.getNroCuenta());
				cuentaD.setIdBanco(cuenta.getBanco().getId());
				cuenta.setId(idOrigenFinanciero);
				getDefaultDao().insert(cuentaD);
				return cuentaD.getIdOrigenFinanciero();
			}
		});
	}

	public List<Cuenta> obtenerCuentas() {
		List<Cuenta> list = new ArrayList<Cuenta>();
		OrigenFinancieroBL orBL = new OrigenFinancieroBL(context);
		for (CuentaD cuenta : getDefaultDao().loadAll()) {
			OrigenFinanciero or = orBL.getOrigenFinanciero(cuenta
					.getIdOrigenFinanciero());
			Cuenta cc = new Cuenta(or.getSaldo(), cuenta.getNroCuenta(),
					new Banco(cuenta.getBanco()));
			cc.setId(or.getId());
			cc.setIcoResImagen(or.getIcoResImagen());
			list.add(cc);
		}
		return list;
	}
}
