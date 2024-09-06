package com.ipartek.modelo.dto;

public class Categoria {
	private int id;
	private String nombre;
	
	public Categoria(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	public Categoria() {
		super();
		this.id = 0;
		this.nombre = "";
	}
	
}
