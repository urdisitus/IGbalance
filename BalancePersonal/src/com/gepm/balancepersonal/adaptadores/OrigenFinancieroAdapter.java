package com.gepm.balancepersonal.adaptadores;

import java.util.List;

import com.gepm.balancepersonal.R;
import com.gepm.balancepersonal.base.LetraUtils;
import com.gepm.balancepersonal.negocio.entidades.Cuenta;
import com.gepm.balancepersonal.negocio.entidades.Efectivo;
import com.gepm.balancepersonal.negocio.entidades.Movimiento;
import com.gepm.balancepersonal.negocio.entidades.OrigenFinanciero;
import com.gepm.balancepersonal.negocio.entidades.TipoMovimiento;
import com.gepm.balancepersonal.utils.Utils;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OrigenFinancieroAdapter extends BaseExpandableListAdapter {

	private List<OrigenFinanciero> cuentas;
	private Context context;

	public OrigenFinancieroAdapter(Context context,
			List<OrigenFinanciero> cuentas) {
		this.cuentas = cuentas;
		this.context = context;
	}

	@Override
	public int getGroupCount() {
		return cuentas.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return cuentas.get(groupPosition).getMovimientos(context).size();
	}

	@Override
	public OrigenFinanciero getGroup(int groupPosition) {
		return cuentas.get(groupPosition);
	}

	@Override
	public Movimiento getChild(int groupPosition, int childPosition) {
		return getGroup(groupPosition).getMovimientos(context).get(
				childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return getGroup(groupPosition).getId();
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return getChild(groupPosition, childPosition).getId();
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	class ViewHolderGroup {
		ImageView imgLogoCuenta, imgEstado;
		TextView lblNroCuenta, lblNombreBanco, lblSaldo;
	}

	class ViewHolderChild {
		ImageView imgCategoria;
		TextView lblNombreCategoria, lblFecha, lblImporte;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		ViewHolderGroup holderG = null;
		if (convertView == null) {
			holderG = new ViewHolderGroup();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_group_cuentas, parent, false);
			holderG.imgEstado = (ImageView) convertView
					.findViewById(R.id.img_ic_estado_cuenta);
			holderG.imgLogoCuenta = (ImageView) convertView
					.findViewById(R.id.img_logo_cuenta);
			holderG.lblNombreBanco = (TextView) convertView
					.findViewById(R.id.lbl_nombre_banco);
			holderG.lblNroCuenta = (TextView) convertView
					.findViewById(R.id.lbl_nro_cuenta);
			holderG.lblSaldo = (TextView) convertView
					.findViewById(R.id.lbl_saldo);
			LetraUtils.setRegularHelveticaNeue(holderG.lblSaldo,
					holderG.lblNombreBanco, holderG.lblNroCuenta);
			convertView.setTag(holderG);
		} else {
			holderG = (ViewHolderGroup) convertView.getTag();
		}
		OrigenFinanciero c = getGroup(groupPosition);
		holderG.lblNombreBanco.setText(c.getNombre());
		holderG.lblSaldo.setText(Utils.doubleToStringFormater(c.getSaldo())
				+ " Bs.");
		holderG.imgLogoCuenta.setImageResource((int) c.getIcoResImagen());
		if (c instanceof Efectivo) {
			holderG.lblNroCuenta.setVisibility(View.INVISIBLE);
		} else {
			holderG.lblNroCuenta.setVisibility(View.VISIBLE);
			holderG.lblNroCuenta.setText(((Cuenta) c).getNroCuenta());
		}
		if (c.getSaldo() > 0) {
			holderG.lblSaldo.setTextColor(context.getResources().getColor(
					android.R.color.holo_green_light));
		} else {
			holderG.lblSaldo.setTextColor(context.getResources().getColor(
					android.R.color.holo_red_light));
		}
		// if (isExpanded) {
		// holderG.imgEstado.setImageResource(R.drawable.arrow_down);
		// } else {
		// holderG.imgEstado.setImageResource(R.drawable.arrow_down);
		// }
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		ViewHolderChild holder = null;
		if (convertView == null) {
			holder = new ViewHolderChild();
			convertView = LayoutInflater.from(context).inflate(
					R.layout.item_ultimos_movimientos, parent, false);
			holder.imgCategoria = (ImageView) convertView
					.findViewById(R.id.img_logo_categoria);
			holder.lblNombreCategoria = (TextView) convertView
					.findViewById(R.id.lbl_nombre_categoria);
			holder.lblFecha = (TextView) convertView
					.findViewById(R.id.lbl_fecha);
			holder.lblImporte = (TextView) convertView
					.findViewById(R.id.lbl_monto);
			LetraUtils.setBoldHelveticaNeue(holder.lblFecha);
			LetraUtils.setRegularHelveticaNeue(holder.lblImporte,
					holder.lblNombreCategoria);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolderChild) convertView.getTag();
		}
		Movimiento c = getChild(groupPosition, childPosition);
		holder.lblNombreCategoria.setText(c.getCategoria().getNombre());
		if (TipoMovimiento.GASTO == c.getTipoMovimiento()) {
			holder.lblImporte.setText(Utils.doubleToStringFormater(c
					.getImporte() * -1)
					+ " Bs.");
			holder.lblImporte.setTextColor(context.getResources().getColor(
					android.R.color.holo_red_light));
		} else {
			holder.lblImporte.setText(Utils.doubleToStringFormater(c
					.getImporte()) + " Bs.");
			holder.lblImporte.setTextColor(context.getResources().getColor(
					android.R.color.holo_green_light));
		}
		holder.lblFecha.setText(Utils.getDate(c.getFecha()));
		holder.imgCategoria.setImageResource((int) c.getCategoria()
				.getIcResImagen());
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
