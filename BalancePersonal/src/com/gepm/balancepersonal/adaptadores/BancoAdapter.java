package com.gepm.balancepersonal.adaptadores;

import java.util.List;

import com.ernesto.perez.balancepersonal.entidades.Banco;
import com.gepm.balancepersonal.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BancoAdapter extends ArrayAdapter<Banco> {

	public BancoAdapter(Context context, List<Banco> objects) {
		super(context, R.layout.item_banco, objects);
	}

	class ViewHolder {
		TextView lblNombre;
		ImageView imgLogo;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return getView(position, convertView, parent, R.layout.item_banco);
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getView(position, convertView, parent,
				R.layout.item_banco_drop_down);
	}

	public View getView(int position, View convertView, ViewGroup parent,
			int idRes) {
		ViewHolder holder = new ViewHolder();
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(getContext()).inflate(idRes,
					parent, false);
			holder.imgLogo = (ImageView) convertView
					.findViewById(R.id.img_logo_banco);
			holder.lblNombre = (TextView) convertView
					.findViewById(R.id.lbl_nombre_banco);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Banco b = getItem(position);
		holder.lblNombre.setText(b.getNombre());
		return convertView;
	}
}
