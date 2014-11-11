package com.gepm.balancepersonal.negocio;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.ernesto.perez.balancepersonal.daos.BancoDDao;
import com.ernesto.perez.balancepersonal.daos.DaoSession;
import com.ernesto.perez.balancepersonal.datos.entidades.BancoD;
import com.gepm.balancepersonal.negocio.entidades.Banco;

public class BancoBL extends ObjetoBL<BancoDDao>{

	public BancoBL(Context context) {
		super(context);
	}

	@Override
	protected BancoDDao getDao(DaoSession daoSession) {
		return daoSession.getBancoDDao();
	} 
	
	public long insertar(Banco banco){
		BancoD bd = new BancoD();
		bd.setNombre(banco.getNombre());
		bd.setResImagen(banco.getIcResImagen());
		bd.setTipo(banco.getTipo());
		getDefaultDao().insert(bd);
		banco.setId(bd.getId());
		return bd.getId();
	}
	
	public List<Banco> obtenerBancos(){
		List<Banco> list = new ArrayList<Banco>();
		for (BancoD banco : getDefaultDao().loadAll()) {
			list.add(new Banco(banco.getId(), banco.getNombre(),banco.getResImagen(), banco.getTipo()));
		}
		return list;
	}
	
}
