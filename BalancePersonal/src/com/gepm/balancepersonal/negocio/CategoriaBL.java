package com.gepm.balancepersonal.negocio;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.ernesto.perez.balancepersonal.daos.CategoriaDDao;
import com.ernesto.perez.balancepersonal.daos.CategoriaDDao.Properties;
import com.ernesto.perez.balancepersonal.daos.DaoSession;
import com.ernesto.perez.balancepersonal.datos.entidades.CategoriaD;
import com.gepm.balancepersonal.R;
import com.gepm.balancepersonal.negocio.entidades.Categoria;

public class CategoriaBL extends ObjetoBL<CategoriaDDao> {

	public static final Categoria saldoInicial = new Categoria(1L,
			"Saldo inicial", R.drawable.money_3);

	public CategoriaBL(Context context) {
		super(context);
	}

	

	@Override
	protected CategoriaDDao getDao(DaoSession daoSession) {
		return daoSession.getCategoriaDDao();
	}

	public List<Categoria> obtenerBancos() {
		List<Categoria> list = new ArrayList<Categoria>();
		for (CategoriaD cate : getDefaultDao().queryBuilder()
				.where(Properties.Id.gt(1L)).build().list()) {
			list.add(new Categoria(cate.getId(), cate.getNombre(), cate
					.getResImagen()));
		}
		return list;
	}

}
