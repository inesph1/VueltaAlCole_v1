package com.ipartek.modelo;

import java.sql.Connection;

public interface I_Conexion {
	
	//Conexion a la BD
	String BASE_DATOS = "vueltacole";
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/"+BASE_DATOS;
	String USUARIO = "root";
	String PASS = "1234";
	
	//tablas y views de la BD
	String TABLA_PRODUCTOS="productos";
	String PRODUCTOS_ID="id";
	String PRODUCTOS_NOMBRE="nombre";
	String PRODUCTOS_PRECIO="precio";
	String PRODUCTOS_FK_CATEGORIA="FK_categoria";
	
	String TABLA_CATEGORIAS="categorias";
	String CATEGORIAS_ID="id";
	String CATEGORIAS_NOMBRE="nombre";
	
	String VIEW_PRODUCTOS="productos";
	String V_PRODUCTOS_ID="id";
	String V_PRODUCTOS_NOMBRE="nombre";
	String V_PRODUCTOS_PRECIO="precio";
	String V_PRODUCTOS_FK_CATEGORIA="FK_categoria";
	String V_PRODUCTOS_CATEGORIA="categoria";
	
	//Archivos JSP
	String JSP_INDEX="index.jsp";

	String ATR_LISTA_PARTICIPANTES = "atr_lista_participantes";


	
	
	


}
