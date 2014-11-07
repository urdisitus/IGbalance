package com.gepm.balancepersonal;

import android.support.v4.app.Fragment;
import com.gepm.balancepersonal.base.BaseActivityConBarra;
import com.gepm.balancepersonal.fragment.CuentaFragment;
import com.gepm.balancepersonal.fragment.NuevaCuentaFragment;

public class NuevaCuentaActivity extends BaseActivityConBarra {

	@Override
	protected int getResIconDrawable() {
		return R.drawable.currency;
	}

	@Override
	protected Fragment getFragmentInicial() {
		return new NuevaCuentaFragment();
	}

	@Override
	protected String getScreenLabel() {
		return "Nueva cuenta";
	}

}
