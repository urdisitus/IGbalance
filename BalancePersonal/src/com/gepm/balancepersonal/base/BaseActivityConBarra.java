package com.gepm.balancepersonal.base;

import com.gepm.balancepersonal.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class BaseActivityConBarra extends BaseActivity {

	private TextView lblTitulo;

	@Override
	protected int getResLayout() {
		return R.layout.activity_base_activity_con_barra;
	}

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
		if (savedInstanceState == null) {
			getSupportFragmentManager()
					.beginTransaction()
					.add(R.id.container_base_activity_con_barra,
							getFragmentInicial()).commit();
		}
	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState) {
		lblTitulo = (TextView) findViewById(R.id.lbl_titulo_base_activity_con_barra);
		lblTitulo.setText(getScreenLabel());
		ImageView imgLogo = (ImageView) findViewById(R.id.img_icon_base_activity_con_barra);
		imgLogo.setImageResource(getResIconDrawable());
		LetraUtils.setRegularHelveticaNeue(lblTitulo);
	}

	protected abstract int getResIconDrawable();

	protected abstract Fragment getFragmentInicial();

}
