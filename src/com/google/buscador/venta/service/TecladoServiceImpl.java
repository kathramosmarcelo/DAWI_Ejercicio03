package com.google.buscador.venta.service;

import java.util.List;

import com.google.buscador.venta.bean.CategoriaBean;
import com.google.buscador.venta.bean.TecladoBean;
import com.google.buscador.venta.daos.DAOFactory;
import com.google.buscador.venta.daos.TecladoDAO;


public class TecladoServiceImpl implements TecladoService{

	DAOFactory fabrica = DAOFactory.getFactorty(DAOFactory.MYSQL);
	TecladoDAO dao = fabrica.getTeclado();
	
	@Override
	public int insertaTeclado(TecladoBean obj) throws Exception {
		return dao.insertaTeclado(obj);
	}
	
	
	@Override
	public List<CategoriaBean> listaCategoria() throws Exception {
		return dao.listaCategoria();

	}



}
