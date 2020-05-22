package com.google.buscador.venta.daos;

import java.util.List;

import com.google.buscador.venta.bean.TecladoBean;
import com.google.buscador.venta.bean.CategoriaBean;

public interface TecladoDAO {

	public int insertaTeclado(TecladoBean obj) throws Exception;
	
	public List<CategoriaBean> listaCategoria() throws Exception;
	
	
}
