package com.ipartek.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.ipartek.modelo.dto.Participante;

public class DB_Helper implements I_Conexion, I_Metodos {

	@Override
	public Connection conectar() {

		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USUARIO, PASS);

			System.out.println("BD conectada");
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se encontro el driver");
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se pudo conectar a la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}

		return con;
	}

	@Override
	public void desconectar(Connection con) {

		try {
			con.close();
			System.out.println("BD desconectada");
		} catch (SQLException e) {
			System.out.println("ERROR DE BD");
			System.out.println("No se pudo desconectar de la BD");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("ERROR DE BD");
			System.out.println("Error desconocido");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public int insertarParticipante(Connection con, Participante participanteInsertar) {

		try {
			// call sp_insertar_producto(nombre, apellidos, edad);
			CallableStatement cStmt = con.prepareCall(SP_INSERTAR_PARTICIPANTE);

			cStmt.setString(1, participanteInsertar.getNombre());
			cStmt.setString(2, participanteInsertar.getApellidos());
			cStmt.setInt(3, participanteInsertar.getEdad());

			return cStmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR DE BD: INSERTAR");
			System.out.println("No se pudo insertar el participante");

			return 0;
		}

	}

	public List<Participante> obtenerTodosParticipantes(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}

}
