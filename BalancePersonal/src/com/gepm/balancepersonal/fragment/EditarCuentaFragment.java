package com.gepm.balancepersonal.fragment;

import android.os.Bundle;
import android.view.View;

import com.gepm.balancepersonal.negocio.entidades.Banco;

public class EditarCuentaFragment extends CuentaFragment {

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		super.instaciarIGU(savedInstanceState, v);
		txtSaldo.setEnabled(false);
	}

	@Override
	protected void onCancelarClick() {
		getActivity().onBackPressed();
	}

	@Override
	protected void onGuardarClick(Banco banco, String nroCuenta, double saldo) {
		
	}
}
