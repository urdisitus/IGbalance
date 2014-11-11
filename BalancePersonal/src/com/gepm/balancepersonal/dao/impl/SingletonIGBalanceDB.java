package com.gepm.balancepersonal.dao.impl;

import com.ernesto.perez.balancepersonal.daos.DaoMaster;
import com.ernesto.perez.balancepersonal.daos.DaoSession;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class SingletonIGBalanceDB {
	public static IGBalanceDB instancia;
	public static final String NOMBRE_BD = "igbalance.sqlite";

	public static IGBalanceDB getCopaTigoBDInstancia(Context context) {
		if (instancia == null) {
			instancia = new IGBalanceDB(context, NOMBRE_BD);
		}
		return instancia;
	}

	public static class IGBalanceDB {
		private SQLiteDatabase db;
		private DaoMaster daoMaster;
		private DaoSession defaultDaoSession;
		private IGOpenHelper helper;

		public IGBalanceDB(Context context, String databaseName) {
			helper = new IGOpenHelper(context, databaseName, null);
			db = helper.getWritableDatabase();
			daoMaster = new DaoMaster(db);
			defaultDaoSession = daoMaster.newSession();
		}

		public DaoSession recrearDefaultDaoSession() {
			defaultDaoSession = daoMaster.newSession();
			return defaultDaoSession;
		}

		public DaoSession getDefaultSession() {
			return defaultDaoSession;
		}
	}
}
