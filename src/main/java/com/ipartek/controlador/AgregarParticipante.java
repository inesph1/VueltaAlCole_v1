package com.ipartek.controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.I_Conexion;
import com.ipartek.modelo.dto.Participante;

@WebServlet("/AgregarParticipante")
public class AgregarParticipante extends HttpServlet implements I_Conexion{
	private static final long serialVersionUID = 1L;
       
    public AgregarParticipante() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				
				//1 recepcion de parametros
				String nombre="";
				if(request.getParameter("p_nombre")!=null) {
					nombre=request.getParameter("p_nombre");
					if (nombre.length()>45) {
						nombre=nombre.substring(0, 45);
					}
				}
				
				String apellidos="";
				if(request.getParameter("p_apellidos")!=null) {
					apellidos=request.getParameter("p_apellidos");
					if (apellidos.length()>45) {
						apellidos=apellidos.substring(0, 45);
					}
				}
				
				
				
				int edad=0;
				if(request.getParameter("p_edad")!=null) {
					try {
						edad=Integer.parseInt(request.getParameter("p_edad"));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						edad=0;
					}
				}
				
				
				
				//2 maquetar a objetos
				Participante participanteInsertar= new Participante(0, nombre, apellidos, 0);
				
				//3
				DB_Helper db = new DB_Helper();
				Connection con = db.conectar();

				//4
				int resultadoInsert=db.insertarParticipante(con, participanteInsertar);
				List<Participante> listaParticipantes=db.obtenerListaParticipantes(con);
		
				
				//5
				db.desconectar(con);
				
				//6
				request.setAttribute(ATR_LISTA_PARTICIPANTES, listaParticipantes);
				//7 viaje
				request.getRequestDispatcher(JSP_INDEX).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
