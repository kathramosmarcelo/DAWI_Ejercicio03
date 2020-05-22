package com.google.buscador.venta.daos;


public class MySqlDAOFActory extends DAOFactory {

	
	
	@Override
	public TecladoDAO getTeclado() {
	
		return new MySqlTecladoDAO();
	}

	
}
