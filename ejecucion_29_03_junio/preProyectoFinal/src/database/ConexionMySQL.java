package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionMySQL {
	
	private static Connection conn = null;

	
	static {
		String Controlador = "com.mysql.jdbc.Driver";
		String URL = "jdbc:mysql://localhost:3306/db_proyectomodulo1";
		String Usuario = "root";
		String Clave = "nicky";
		
		try {
			Class.forName(Controlador);
			conn = DriverManager.getConnection(URL, Usuario, Clave);
			if(conn != null) {
				System.out.println("¡Conexión establecida!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error al cargar el controlador. ");
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection() { 
		
		return conn;
	
	}
	
	public void desconectar() {
	conn = null;
			if(conn == null) {
				System.out.println("¡Conexión finalizada!");
			}
	}

}

