package com.google.buscador.venta.daos;


public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int ORACLE = 2;


	public abstract TecladoDAO getTeclado();
	
	// Se aplica polimorfismo
	public static MySqlDAOFActory getFactorty(int bd) {
		switch (bd) {
			case MYSQL:
				return new MySqlDAOFActory();
			
		}
		return null;
	}

	
	

}
