package com.gepm.balancepersonal.base;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.gepm.balancepersonal.R;
import com.gepm.balancepersonal.base.listeners.IDialogoConfirmarOkCancel;
import com.gepm.balancepersonal.base.listeners.IDialogoConfirmarSoloAceptar;

public class DialogoConfirmacion extends DialogFragment implements
		OnClickListener {

	public static final String key_mensaje = "mensaje";
	public static final String key_object = "object";
	public static final String key_title = "title";
	public static final String key_ok_button = "boton_ok";
	public static final String key_cancel_button = "boton_cancel";
	private IDialogoConfirmarSoloAceptar listener;
	private boolean hasCancel;
	private Parcelable object;

	public void setListener(IDialogoConfirmarSoloAceptar listener) {
		this.listener = listener;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		String mensaje = getArguments().getString(key_mensaje);
		String title = getArguments().getString(key_title);
		String okName = getArguments().getString(key_ok_button);
		String cancelName = getArguments().getString(key_cancel_button);
		View v = inflater.inflate(R.layout.dialogo_confirmacion, container,
				false);
		TextView lblTile = (TextView) v
				.findViewById(R.id.lbl_title_dialogo_confirmacion);
		TextView lblMensaje = (TextView) v
				.findViewById(R.id.lbl_mensaje_dialogo_confirmacion);

		Button btnSi = (Button) v
				.findViewById(R.id.btn_si_dialogo_confirmacion);

		if (okName != null && !okName.trim().equals("")) {
			btnSi.setText(okName);
		}
		btnSi.setOnClickListener(this);
		Button btnNo = (Button) v
				.findViewById(R.id.btn_no_dialogo_confirmacion);
		LetraUtils.setRegularHelveticaNeue(lblMensaje);
		LetraUtils.setRegularHelveticaNeue(btnSi);
		LetraUtils.setRegularHelveticaNeue(btnNo);
		LetraUtils.setRegularHelveticaNeue(lblTile);
		if (cancelName != null && !cancelName.trim().equals("")) {
			btnNo.setText(cancelName);
		}
		if (title == null) {
			lblTile.setVisibility(View.GONE);
		} else {
			lblTile.setText(title);
		}
		lblMensaje.setText(mensaje);
		object = getArguments().getParcelable(key_object);
		hasCancel = (listener != null && listener instanceof IDialogoConfirmarOkCancel);
		if (!hasCancel) {
			btnNo.setVisibility(View.GONE);
		} else {
			btnNo.setVisibility(View.VISIBLE);
			btnNo.setOnClickListener(this);
		}
		return v;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_si_dialogo_confirmacion:
			if (listener != null) {
				listener.aceptar(object);
			}
			dismiss();
			break;
		case R.id.btn_no_dialogo_confirmacion:
			if (listener != null
					&& listener instanceof IDialogoConfirmarOkCancel) {
				((IDialogoConfirmarOkCancel) listener).cancelar();
			}
			dismiss();
			break;
		default:
			break;
		}
	}
}
