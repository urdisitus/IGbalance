package com.gepm.balancepersonal;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

import com.gepm.balancepersonal.adaptadores.OrigenFinancieroAdapter;
import com.gepm.balancepersonal.base.BaseActivity;
import com.gepm.balancepersonal.base.LetraUtils;
import com.gepm.balancepersonal.negocio.CuentaBL;
import com.gepm.balancepersonal.negocio.entidades.Efectivo;
import com.gepm.balancepersonal.negocio.entidades.OrigenFinanciero;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

public class MainActivity extends BaseActivity implements OnChildClickListener,
		OnClickListener {

	private List<OrigenFinanciero> origenesFinancieros = new ArrayList<OrigenFinanciero>();
	private ExpandableListView expandableListView;
	private OrigenFinancieroAdapter cuentaAdapter;
	private CuentaBL cuentaBL;

	private ResideMenu resideMenu;
	private ResideMenuItem itemPrincipal;
	private ResideMenuItem itemMevimientosMes;
	private ResideMenuItem itemIngreso;
	private ResideMenuItem itemGasto;
	private ResideMenuItem itemAgregarCuenta;

	@Override
	public boolean onChildClick(ExpandableListView parent, View v,
			int groupPosition, int childPosition, long id) {
		return false;
	}

	@Override
	protected int getResLayout() {
		return R.layout.activity_main;
	}

	@Override
	protected void inicializarVariables(Bundle savedInstanceState) {
		cuentaBL = new CuentaBL(this);
		cuentaAdapter = new OrigenFinancieroAdapter(this, origenesFinancieros);
	}

	@Override
	protected void onResume() {
		super.onResume();
		origenesFinancieros.clear();
		origenesFinancieros.add(new Efectivo(this));
		origenesFinancieros.addAll(cuentaBL.obtenerCuentas());
		cuentaAdapter.notifyDataSetChanged();
	}

	@Override
	protected void instaciarIGU(Bundle savedInstanceState) {
		setUpMenu();
		expandableListView = (ExpandableListView) findViewById(R.id.exp_cuentas);
		expandableListView.setAdapter(cuentaAdapter);
		expandableListView.setOnChildClickListener(this);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		return resideMenu.dispatchTouchEvent(ev);
	}

	private void setUpMenu() {

		// attach to current activity;
		resideMenu = new ResideMenu(this);
		resideMenu.setBackground(R.drawable.fondo_gasto);
		resideMenu.attachToActivity(this);
		// resideMenu.setMenuListener(menuListener);
		// valid scale factor is between 0.0f and 1.0f. leftmenu'width is
		// 150dip.
		resideMenu.setScaleValue(0.6f);

		// create menu items;
		itemPrincipal = new ResideMenuItem(this, R.drawable.home, "Principal");
		itemMevimientosMes = new ResideMenuItem(this, R.drawable.stat, "Mes");
		itemAgregarCuenta = new ResideMenuItem(this, R.drawable.add,
				"Cuenta");
		itemIngreso = new ResideMenuItem(this, R.drawable.download,
				"Ingreso");
		itemGasto = new ResideMenuItem(this, R.drawable.upload, "Gasto");

		LetraUtils.setRegularHelveticaNeue(itemPrincipal.getTv_title(),
				itemAgregarCuenta.getTv_title(),
				itemMevimientosMes.getTv_title(), itemIngreso.getTv_title(),
				itemGasto.getTv_title());

		itemPrincipal.setOnClickListener(this);
		itemMevimientosMes.setOnClickListener(this);
		itemAgregarCuenta.setOnClickListener(this);
		itemIngreso.setOnClickListener(this);
		itemGasto.setOnClickListener(this);

		resideMenu.addMenuItem(itemPrincipal, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemMevimientosMes, ResideMenu.DIRECTION_LEFT);
		resideMenu.addMenuItem(itemAgregarCuenta, ResideMenu.DIRECTION_RIGHT);
		resideMenu.addMenuItem(itemIngreso, ResideMenu.DIRECTION_RIGHT);
		resideMenu.addMenuItem(itemGasto, ResideMenu.DIRECTION_RIGHT);

		// You can disable a direction by setting ->
		// resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

		// findViewById(R.id.title_bar_left_menu).setOnClickListener(
		// new View.OnClickListener() {
		// @Override
		// public void onClick(View view) {
		// resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
		// }
		// });
		// findViewById(R.id.title_bar_right_menu).setOnClickListener(
		// new View.OnClickListener() {
		// @Override
		// public void onClick(View view) {
		// resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
		// }
		// });
	}

	@Override
	protected String getScreenLabel() {
		return "Principal";
	}

	@Override
	public void onClick(View view) {

		// if (view == itemHome) {
		// changeFragment(new HomeFragment());
		// } else if (view == itemProfile) {
		// changeFragment(new ProfileFragment());
		// } else if (view == itemCalendar) {
		// changeFragment(new CalendarFragment());
		// } else if (view == itemSettings) {
		// changeFragment(new SettingsFragment());
		// }
		if (view == itemAgregarCuenta) {
			startActivity(new Intent(this, NuevaCuentaActivity.class));
		}
		resideMenu.closeMenu();
	}
}
