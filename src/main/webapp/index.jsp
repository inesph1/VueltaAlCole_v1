<%@page import="com.ipartek.modelo.I_Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Participante"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
List<Participante> listaParticipantes = new ArrayList<Participante>();
if (request.getAttribute(I_Conexion.ATR_LISTA_PARTICIPANTES) != null) {
	listaParticipantes = (List<Participante>) request.getAttribute(I_Conexion.ATR_LISTA_PARTICIPANTES);
} else {
	//TAREA PARA METER EN EL LOG
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header> CABECERA </header>

	<nav>MENU</nav>

	<main>

		<section>
			<form action="" method="get">
				<label for="">Nombre</label> <input type="text" id="" name="">
				<br> <label for="">Apellidos</label> <input type="text" id=""
					name=""> <br> <label for="">Edad</label> <input
					type="submit" value="Guardar">
			</form>
		</section>

		<section>
			<table border="1">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Apellidos</th>
						<th>Edad</th>
						<th>Opciones</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Participante elem : listaParticipantes) {
					%>
					<tr>
						<td><%=elem.getId()%></td>
						<td><%=elem.getNombre()%></td>
						<td><%=elem.getApellidos()%></td>
						<td><%=elem.getEdad()%></td>
						<td><a href="#">Editar</a> <a
							href="EliminarProducto?id=<%=elem.getId()%>">Eliminar</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>


		</section>

	</main>

	<footer> PIE </footer>






</body>
</html>