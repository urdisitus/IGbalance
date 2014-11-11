package com.gepm.balancepersonal.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import com.ernesto.perez.balancepersonal.daos.DaoMaster;
import com.ernesto.perez.balancepersonal.daos.DaoMaster.OpenHelper;
import com.gepm.balancepersonal.R;
import com.gepm.balancepersonal.negocio.CategoriaBL;
import com.gepm.balancepersonal.negocio.OrigenFinancieroBL;
import com.gepm.balancepersonal.negocio.entidades.Banco;
import com.gepm.balancepersonal.negocio.entidades.Efectivo;

public class IGOpenHelper extends OpenHelper {

	private Context context;

	public IGOpenHelper(Context context, String name, CursorFactory factory) {
		super(context, name, factory);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("greenDAO", "Creating tables for schema version "
				+ DaoMaster.SCHEMA_VERSION);
		DaoMaster.createAllTables(db, true);
//		Efectivo ef = new Efectivo(context);
//		OrigenFinancieroBL orf = new OrigenFinancieroBL(context);
//		if (orf.getOrigenFinanciero(ef.getId()) == null) {
//			orf.insertar(0, 0, ef);
//			CategoriaBL catBl = new CategoriaBL(context);
//			catBl.getDefaultDao().insertOrReplace(
//					CategoriaBL.saldoInicial.toCategoriaD());
//
//			List<Banco> list = new ArrayList<Banco>();
//			list.add(new Banco(1L, "Banco Bisa", R.drawable.bank, 0));
//			list.add(new Banco(2L, "Banco Central de Bolivia", R.drawable.bank,
//					0));
//			list.add(new Banco(3L, "Banco Económico", R.drawable.bank, 0));
//			list.add(new Banco(4L, "Banco Ganadero", R.drawable.bank, 0));
//			list.add(new Banco(5L, "Banco Mercantil Santa Cruz",
//					R.drawable.bank, 0));
//		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		DaoMaster.dropAllTables(db, true);
		onCreate(db);
		// switch (oldVersion) {
		// case 1:
		// // hacer los cambios
		// break;
		//
		// default:
		// break;
		// }
	}
}
