package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.DAOException;
import database.ConexionMySQL;
import modelos.Operador;


public class OperadorController {
	
	Connection conn = ConexionMySQL.getConnection();
	
	public boolean validarOperador(String usuario, String password) throws DAOException {
		String SQL = "SELECT idOperador, nombre, apellido FROM operadores WHERE idOperador =' "+usuario+"' AND password ='"+password+"'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean verificador = false;
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("¡Operador verificado!. ID = "+usuario);
				System.out.println();
				return true;
			} else {
				System.out.println("¡ID o contraseña incorreto!. Reintente.");
				return false;
			}
		}catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
				
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					new DAOException("Error en SQL", ex);
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					new DAOException("Error en SQL", ex);
				}
			}
		}
	}
}
