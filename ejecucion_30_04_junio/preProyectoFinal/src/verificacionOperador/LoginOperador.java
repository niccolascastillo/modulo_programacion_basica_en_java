package verificacionOperador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConexionMySQL;

public class LoginOperador {
	
	Connection conn = ConexionMySQL.getConnection();
	
	public validarOperador(String usuario, String password) {
		
		String SQL = "SELECT idOperador, nombre FROM operadores WHERE idOperador =' "+usuario+"' AND password ='"+password+"'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("¡Operador verificado!. ID = "+usuario);
				System.out.println();
				return null;
			} else {
				System.out.println("¡ID o contraseña incorreto!. Reintente.");
			}
		} catch (Exception e) {

		}
	}
			

}
