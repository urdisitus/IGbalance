package com.gepm.balancepersonal.fragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.ernesto.perez.balancepersonal.entidades.Banco;
import com.gepm.balancepersonal.R;
import com.gepm.balancepersonal.adaptadores.BancoAdapter;
import com.gepm.balancepersonal.base.BaseFragment;
import com.gepm.balancepersonal.base.LetraUtils;
import com.gepm.balancepersonal.base.listeners.IBaseActivity;

public abstract class CuentaFragment extends BaseFragment<IBaseActivity>
		implements OnClickListener {

	protected EditText txtNro, txtSaldo;
	protected Spinner spnBanco;
	private BancoAdapter adapter;

	protected abstract void onGuardarClick(Banco banco, String nroCuenta,
			double saldo);

	protected abstract void onCancelarClick();

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
		List<Banco> list = new ArrayList<Banco>();
		list.add(new Banco(0L, "Banco Bisa", 0, Calendar.getInstance()
				.getTime(), null));
		list.add(new Banco(0L, "Banco Central de Bolivia", 0, Calendar
				.getInstance().getTime(), null));
		list.add(new Banco(0L, "Banco Económico", 0, Calendar.getInstance()
				.getTime(), null));
		list.add(new Banco(0L, "Banco Ganadero", 0, Calendar.getInstance()
				.getTime(), null));
		list.add(new Banco(0L, "Banco Mercantil Santa Cruz", 0, Calendar
				.getInstance().getTime(), null));
		adapter = new BancoAdapter(getActivity(), list);
	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		Button btnGuardar, btnCancelar;
		btnGuardar = (Button) v.findViewById(R.id.btn_guardar);
		btnCancelar = (Button) v.findViewById(R.id.btn_cancelar);
		btnGuardar.setOnClickListener(this);
		btnCancelar.setOnClickListener(this);
		TextView tltNro, tltSaldo, tltBanco;
		tltBanco = (TextView) v.findViewById(R.id.tlt_banco_cuenta);
		tltNro = (TextView) v.findViewById(R.id.tlt_nro_cuenta);
		tltSaldo = (TextView) v.findViewById(R.id.tlt_saldo_cuenta);
		txtNro = (EditText) v.findViewById(R.id.txt_nro_cuenta);
		txtSaldo = (EditText) v.findViewById(R.id.txt_saldo_cuenta);
		LetraUtils.setRegularHelveticaNeue(txtNro, txtSaldo, tltBanco, tltNro,
				tltSaldo);
		LetraUtils.setBoldHelveticaNeue(btnCancelar, btnGuardar);
		spnBanco = (Spinner) v.findViewById(R.id.spn_banco_cuenta);
		spnBanco.setAdapter(adapter);
	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_cuenta;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_guardar:
			String mensaje = validar();
			if (mensaje == null) {
				onGuardarClick(
						null,
						txtNro.getText().toString().trim(),
						Double.parseDouble(txtSaldo.getText().toString().trim()));
			} else {
				showAlert(null, "Aviso", mensaje, "btnGuardar");
			}
			break;

		case R.id.btn_cancelar:
			onCancelarClick();
			break;

		default:
			break;
		}
	}

	private String validar() {
		if (txtNro.getText().toString().trim().equals("")) {
			txtNro.requestFocus();
			return "En nro de cuenta introducido es ivalido";
		}
		if (txtSaldo.getText().toString().trim().equals("")) {
			txtSaldo.requestFocus();
			return "El saldo introducido es invalido.";
		}
		return null;
	}
}
