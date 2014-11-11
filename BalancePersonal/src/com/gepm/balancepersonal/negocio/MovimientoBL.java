package com.gepm.balancepersonal.negocio;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.ernesto.perez.balancepersonal.daos.DaoSession;
import com.ernesto.perez.balancepersonal.daos.MovimientoDDao;
import com.ernesto.perez.balancepersonal.daos.MovimientoDDao.Properties;
import com.ernesto.perez.balancepersonal.datos.entidades.MovimientoD;
import com.ernesto.perez.balancepersonal.datos.entidades.OrigenFinancieroD;
import com.gepm.balancepersonal.negocio.entidades.Adjunto;
import com.gepm.balancepersonal.negocio.entidades.AnulacionMovimiento;
import com.gepm.balancepersonal.negocio.entidades.Categoria;
import com.gepm.balancepersonal.negocio.entidades.Movimiento;
import com.gepm.balancepersonal.negocio.entidades.OrigenFinanciero;
import com.gepm.balancepersonal.negocio.entidades.TipoMovimiento;

public class MovimientoBL extends ObjetoBL<MovimientoDDao> {

	public MovimientoBL(Context context) {
		super(context);
	}

	@Override
	protected MovimientoDDao getDao(DaoSession daoSession) {
		return daoSession.getMovimientoDDao();
	}
	
	public void insertarMovimiento(Movimiento movimiento){
		
	}
	

	public long insertarInTransaccion(Movimiento movimiento) {
		MovimientoD mov = new MovimientoD();
		if (movimiento.getAdjunto() != null) {
			mov.setIdAdjunto(movimiento.getAdjunto().getId());
		}
		mov.setLatitud(movimiento.getLatitud());
		mov.setLongitud(movimiento.getLongitud());
		mov.setConcepto(movimiento.getConcepto());
		mov.setFechaHora(movimiento.getFecha());
		mov.setImporte(movimiento.getImporte());
		mov.setTipoMovimiento(movimiento.getTipoMovimiento().ordinal());
		mov.setIdCategoria(movimiento.getCategoria().getId());
		mov.setIdOrigenFinanciero(movimiento.getOrigenFinanciero().getId());
		getDefaultDao().insert(mov);

		OrigenFinancieroD or = getDefaultDaoSession().getOrigenFinancieroDDao()
				.load(movimiento.getOrigenFinanciero().getId());
		double importeReal = movimiento.getImporte();
		if (movimiento.getTipoMovimiento() == TipoMovimiento.GASTO) {
			importeReal *= -1;
		}
		or.setSaldo(or.getSaldo() + importeReal);
		getDefaultDaoSession().getOrigenFinancieroDDao().update(or);
		return mov.getId();
	}

	public List<Movimiento> getMovimientos(OrigenFinanciero origenFinanciero,
			int limit) {
		List<Movimiento> movs = new ArrayList<Movimiento>();
		for (MovimientoD movimiento : getDefaultDao()
				.queryBuilder()
				.where(Properties.IdOrigenFinanciero.eq(origenFinanciero
						.getId())).limit(limit).build().list()) {
			Movimiento mv = new Movimiento(movimiento.getId().longValue(),
					movimiento.getConcepto(), movimiento.getLatitud(),
					movimiento.getLongitud(), movimiento.getFechaHora(),
					movimiento.getImporte(), new Categoria(
							movimiento.getCategoria()), new OrigenFinanciero(
							movimiento.getMovimientos()),
					TipoMovimiento.values()[movimiento.getTipoMovimiento()]);
			movs.add(mv);
			if (movimiento.getAdjunto() != null) {
				mv.setAdjunto(new Adjunto(movimiento.getAdjunto().getId()));
			}
			if (movimiento.getAnulacion() != null) {
				mv.setAnulacionMovimiento(new AnulacionMovimiento(movimiento
						.getAdjunto().getId()));
			}
		}
		return movs;
	}
}
