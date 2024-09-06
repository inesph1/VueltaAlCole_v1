package com.ipartek.modelo;

import java.sql.Connection;

public interface I_Conexion {
	
	//Conexion a la BD
	String BASE_DATOS = "github_proyecto";
	String DRIVER = "com.mysql.jdbc.Driver";
	String CONEXION = "jdbc:mysql://192.168.0.98:3306/"+BASE_DATOS;
	String USUARIO = "root";
	String PASS = "1234";
	
	//tablas y views de la BD
	String TABLA_PRODUCTOS="participantes";
	String PARTICIPANTE_ID="id";
	String PARTICIPANTE_NOMBRE="nombre";
	String PARTICIPANTE_APELLIDOS="apellidos";
	String PARTICIPANTE_EDAD="edad";
	
	//procedimientos almacenados
	String SP_INSERTAR_PARTICIPANTE="call sp_sp_insertarParticipante(?, ?, ?);";
	String SP_OBTENER_TODOS_PARTICIPANTES="call sp_obtenerTodosParticipantes();"; 
	
	//Archivos JSP
	String JSP_INDEX="index.jsp";




	
	
	


}
