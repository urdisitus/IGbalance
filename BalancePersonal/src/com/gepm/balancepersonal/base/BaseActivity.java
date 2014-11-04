package com.gepm.balancepersonal.base;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import com.gepm.balancepersonal.R;
import com.gepm.balancepersonal.base.listeners.IBaseActivity;
import com.gepm.balancepersonal.base.listeners.IDialogoConfirmarSoloAceptar;

@SuppressLint("InlinedApi")
public abstract class BaseActivity extends FragmentActivity implements
		IBaseActivity {

	protected abstract int getResLayout();

	protected void overridePendingTransitionStart() {
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}

	protected void overridePendingTransitionEnd() {
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		overridePendingTransitionStart();
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(getResLayout());
		inicializarVariables(savedInstanceState);
		instaciarIGU(savedInstanceState);
	}

	public DialogoConfirmacion showAlert(IDialogoConfirmarSoloAceptar listener,
			String titulo, String mensaje, String okName, String cancelName,
			String TAG) {
		return showAlert(listener, titulo, mensaje, null, okName, cancelName,
				TAG);
	}

	public DialogoConfirmacion showAlert(IDialogoConfirmarSoloAceptar listener,
			String titulo, String mensaje, String TAG) {
		return showAlert(listener, titulo, mensaje, null, null, null, TAG);
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransitionEnd();
	}

	public void showConsumoError(IDialogoConfirmarSoloAceptar listener,
			String TAG) {
		showAlert(listener, "Aviso", getString(R.string.consumo_error_info),
				null, "Aceptar", "", TAG);
	}

	public void showInternetError(IDialogoConfirmarSoloAceptar listener,
			String TAG) {
		showAlert(listener, "Aviso", getString(R.string.internet_error_info),
				null, "Aceptar", "", TAG);
	}

	public DialogoConfirmacion showAlert(IDialogoConfirmarSoloAceptar listener,
			String titulo, String mensaje, Parcelable object, String okName,
			String cancelName, String TAG) {
		DialogoConfirmacion actualDialogo = new DialogoConfirmacion();
		Bundle b = new Bundle();
		b.putString(DialogoConfirmacion.key_mensaje, mensaje);
		b.putString(DialogoConfirmacion.key_title, titulo);
		b.putString(DialogoConfirmacion.key_ok_button, okName);
		b.putString(DialogoConfirmacion.key_cancel_button, cancelName);
		b.putParcelable(DialogoConfirmacion.key_object, object);
		actualDialogo.setArguments(b);
		actualDialogo.setListener(listener);
		// actualDialogo.setStyle(DialogFragment.STYLE_NO_FRAME,
		// R.style.Dialog_No_Border);
		actualDialogo.show(getSupportFragmentManager(), TAG);
		return actualDialogo;
	}

	protected abstract void inicializarVariables(Bundle savedInstanceState);

	protected abstract void instaciarIGU(Bundle savedInstanceState);

	protected abstract String getScreenLabel();

	protected String getAnaliticsLabel() {
		return getScreenLabel();
	}
}
