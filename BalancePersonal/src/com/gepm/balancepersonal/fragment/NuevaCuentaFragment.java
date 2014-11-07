package com.gepm.balancepersonal.fragment;

import com.ernesto.perez.balancepersonal.entidades.Banco;

public class NuevaCuentaFragment extends CuentaFragment {

	@Override
	protected void onCancelarClick() {
		getActivity().onBackPressed();
	}

	@Override
	protected void onGuardarClick(Banco banco, String nroCuenta, double saldo) {

	}
}
