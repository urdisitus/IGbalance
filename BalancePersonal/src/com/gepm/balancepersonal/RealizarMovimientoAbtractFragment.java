package com.gepm.balancepersonal;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.gepm.balancepersonal.base.BaseFragment;
import com.gepm.balancepersonal.base.listeners.IBaseActivity;
import com.gepm.balancepersonal.base.listeners.IDialogoConfirmarOkCancel;
import com.gepm.balancepersonal.negocio.entidades.TipoMovimiento;

public abstract class RealizarMovimientoAbtractFragment extends
		BaseFragment<IBaseActivity> implements OnClickListener {

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {

	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState, View v) {
		metodoPlantillaInicializarPantalla(v);
		v.findViewById(R.id.btn_cancelar).setOnClickListener(this);
		v.findViewById(R.id.btn_aceptar).setOnClickListener(this);
		
	}

	@SuppressWarnings("deprecation")
	public void metodoPlantillaInicializarPantalla(View v) {
		LinearLayout fondo = (LinearLayout) v.findViewById(R.id.lyt_fondo);
		fondo.setBackgroundDrawable(getResources().getDrawable(
				getResFondoPantalla()));
		
	}

	@Override
	protected int viewResource() {
		return R.layout.fragment_registrar_movimiento;
	}

	protected abstract int getResFondoPantalla();
	protected abstract double (Mont);
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_aceptar:
			
			break;
		case R.id.btn_cancelar:
			showAlert(new IDialogoConfirmarOkCancel() {
				
				@Override
				public void aceptar(Parcelable object) {
					getActivity().finish();
				}
				
				@Override
				public void cancelar() {
					
				}
			}, "Confirmación", "Esta seguro que desea salir?\npuede que se pierdan los datos introducidos.", "Aceptar", "Cancelar", "Confimacin");
			break;

		default:
			break;
		}
	}
}
