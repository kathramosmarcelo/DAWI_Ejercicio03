package com.google.buscador.venta.bean;

import lombok.Data;

@Data
public class TecladoBean {

	private int idTeclado;
	private String nombre_te;
	private String color_te;
	private String forma_te;
	private CategoriaBean categoria;
	
}
