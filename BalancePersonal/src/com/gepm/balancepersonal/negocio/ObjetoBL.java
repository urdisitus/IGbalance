package com.gepm.balancepersonal.negocio;

import android.content.Context;

import com.ernesto.perez.balancepersonal.daos.DaoSession;
import com.gepm.balancepersonal.dao.impl.SingletonIGBalanceDB;

import de.greenrobot.dao.AbstractDao;

public abstract class ObjetoBL<T extends AbstractDao<?, ?>> {

	protected Context context;

	protected abstract T getDao(DaoSession daoSession);

	public ObjetoBL(Context context) {
		this.context = context;
	}

	public T getDefaultDao() {
		return getDao(getDefaultDaoSession());
	}

	public T getNewDao() {
		return getDao(getNewDaoSession());
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		context = null;
	}

	protected DaoSession getDefaultDaoSession() {
		return SingletonIGBalanceDB.getCopaTigoBDInstancia(context)
				.getDefaultSession();
	}

	protected DaoSession getNewDaoSession() {
		return SingletonIGBalanceDB.getCopaTigoBDInstancia(context)
				.recrearDefaultDaoSession();
	}
}
