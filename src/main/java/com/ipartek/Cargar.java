package com.ipartek;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Conexion;
import com.ipartek.modelo.dto.Participante;

@WebServlet("/Cargar")
public class Cargar extends HttpServlet implements I_Conexion {
	private static final long serialVersionUID = 1L;
       
    public Cargar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		DB_Helper db= new DB_Helper();
		Connection con=db.conectar();
		
		List<Participante> listadoParticipantes = new ArrayList<Participante>();
		listadoParticipantes = db.obtenerListaParticipantes(con);
		
		
		
		db.desconectar(con);

		
		
		
		request.setAttribute(ATR_LISTA_PARTICIPANTES, listadoParticipantes);
		request.getRequestDispatcher(JSP_INDEX).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
