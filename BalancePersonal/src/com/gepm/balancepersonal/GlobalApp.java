package com.gepm.balancepersonal;

import java.util.ArrayList;
import java.util.List;

import com.gepm.balancepersonal.negocio.BancoBL;
import com.gepm.balancepersonal.negocio.CategoriaBL;
import com.gepm.balancepersonal.negocio.OrigenFinancieroBL;
import com.gepm.balancepersonal.negocio.entidades.Banco;
import com.gepm.balancepersonal.negocio.entidades.Efectivo;

import android.app.Application;
import android.graphics.Typeface;
import android.widget.TextView;

public class GlobalApp extends Application {

	public static Typeface bold, regular, italic, ultraLigth;

	private static GlobalApp miApp;

	@Override
	public void onCreate() {
		super.onCreate();
		miApp = this;
		Efectivo ef = new Efectivo(this);
		OrigenFinancieroBL orf = new OrigenFinancieroBL(this);
		if (orf.getOrigenFinanciero(ef.getId()) == null) {
			orf.insertar(0, 0, ef);
			CategoriaBL catBl = new CategoriaBL(this);
			catBl.getDefaultDao().insertOrReplace(
					CategoriaBL.saldoInicial.toCategoriaD());

			List<Banco> list = new ArrayList<Banco>();
			list.add(new Banco(1L, "Banco Bisa", R.drawable.bisa, 0));
			list.add(new Banco(2L, "Banco Central de Bolivia", R.drawable.bcp,
					0));
			list.add(new Banco(3L, "Banco Económico",
					R.drawable.banco_economico, 0));
			list.add(new Banco(4L, "Banco Ganadero", R.drawable.ganadero, 0));
			list.add(new Banco(5L, "Banco Mercantil Santa Cruz",
					R.drawable.mercantil, 0));
			list.add(new Banco(6L, "Banco Fassil", R.drawable.fassil, 0));
			list.add(new Banco(7L, "Banco Solidario", R.drawable.banco_sol, 0));
			list.add(new Banco(8L, "Banco Unión", R.drawable.banco_union, 0));
			list.add(new Banco(9L, "Banco Nacional de Bolivia", R.drawable.bnb,
					0));
			BancoBL bancoBL = new BancoBL(this);
			for (Banco banco : list) {
				bancoBL.insertar(banco);
			}
		}
		regular = Typeface.createFromAsset(getAssets(),
				"fonts/Comfortaa_Regular.ttf");
		bold = Typeface
				.createFromAsset(getAssets(), "fonts/Comfortaa_Bold.ttf");
		italic = Typeface.createFromAsset(getAssets(),
				"fonts/Comfortaa_Regular.ttf");
		ultraLigth = Typeface.createFromAsset(getAssets(),
				"fonts/Comfortaa_Regular.ttf");
	}

	public static GlobalApp getInstance() {
		return miApp;
	}

	public void setBoldHelveticaNeue(TextView lbl) {
		if (lbl != null && bold != null) {
			lbl.setTypeface(bold);
		}
	}

	public void setItalicHelveticaNeue(TextView lbl) {
		if (lbl != null && italic != null) {
			lbl.setTypeface(italic);
		}
	}

	public void setUltraLigthHelveticaNeue(TextView lbl) {
		if (lbl != null && ultraLigth != null) {
			lbl.setTypeface(ultraLigth);
		}
	}

	public void setRegularHelveticaNeue(TextView lbl) {
		if (lbl != null && regular != null) {
			lbl.setTypeface(regular);
		}
	}
}
