package com.gepm.balancepersonal.fragment;

import com.ernesto.perez.balancepersonal.entidades.Banco;

import android.os.Bundle;
import android.view.View;

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
