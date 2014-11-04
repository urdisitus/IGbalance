package com.gepm.balancepersonal.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gepm.balancepersonal.base.listeners.IBaseActivity;
import com.gepm.balancepersonal.base.listeners.IDialogoConfirmarSoloAceptar;

public abstract class BaseFragment<T extends IBaseActivity> extends Fragment {

	protected T listener;

	@SuppressWarnings("unchecked")
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (activity instanceof IBaseActivity) {
			listener = (T) activity;
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(viewResource(), container, false);
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		inicializarVariables(savedInstanceState);
		instaciarIGU(savedInstanceState, getView());
	}

	protected abstract void inicializarVariables(Bundle savedInstanceState);

	protected abstract void instaciarIGU(Bundle savedInstanceState, View v);

	protected abstract int viewResource();

	public DialogoConfirmacion showAlert(IDialogoConfirmarSoloAceptar listener,
			String titulo, String mensaje, String okName, String cancelName,
			String TAG) {
		return this.listener.showAlert(listener, titulo, mensaje, okName,
				cancelName, TAG);
	}

	public void showConsumoError(IDialogoConfirmarSoloAceptar listener,
			String TAG) {
		this.listener.showConsumoError(listener, TAG);
	}

	public void showInternetError(IDialogoConfirmarSoloAceptar listener,
			String TAG) {
		this.listener.showInternetError(listener, TAG);
	}

	public DialogoConfirmacion showAlert(IDialogoConfirmarSoloAceptar listener,
			String titulo, String mensaje, Parcelable object, String okName,
			String cancelName, String TAG) {
		return this.listener.showAlert(listener, titulo, mensaje, object,
				okName, cancelName, TAG);
	}

	public DialogoConfirmacion showAlert(IDialogoConfirmarSoloAceptar listener,
			String titulo, String mensaje, String TAG) {
		return this.listener.showAlert(listener, titulo, mensaje, TAG);
	}

}
