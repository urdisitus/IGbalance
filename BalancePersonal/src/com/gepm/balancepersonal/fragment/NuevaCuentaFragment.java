package com.gepm.balancepersonal.fragment;

import com.gepm.balancepersonal.negocio.entidades.Banco;
import com.gepm.balancepersonal.negocio.entidades.Cuenta;

public class NuevaCuentaFragment extends CuentaFragment {

	@Override
	protected void onCancelarClick() {
		getActivity().onBackPressed();
	}

	@Override
	protected void onGuardarClick(Banco banco, String nroCuenta, double saldo) {
		Cuenta c = new Cuenta(saldo, nroCuenta, banco);
		try {
			cuentaBL.insertar(0, 0, c);
			getActivity().finish();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
