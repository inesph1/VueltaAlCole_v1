package com.ipartek.modelo;

import java.sql.Connection;

import com.ipartek.modelo.dto.Participante;

public interface I_Metodos {

	Connection conectar();

	void desconectar(Connection con);

	int insertarParticipante(Connection con, Participante participanteInsertar);

}
