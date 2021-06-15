import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConexionMySQL;

/*public class TestConnection {
	public static void main(String[] args) {
		ConexionMySQL conexion = new ConexionMySQL();

		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		
		try {
			cn = conexion.getConnection();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM productos");
			
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				String descripcion = rs.getString(3);
				String tipo = rs.getString(4);
				String afecto = rs.getString(5);
				double precioCompra = rs.getDouble(6);
				double precioVenta = rs.getDouble(7);
				int cantidad = rs.getInt(8);
				
				System.out.println("--- DATOS DEL PRODUCTO ---");
				System.out.println("- ID: " + id);
				System.out.println("- NOMBRE: " + nombre);
				System.out.println("- DESCRIPCIÓN: " + descripcion);
				System.out.println("- TIPO: " + tipo);
				System.out.println("- AFECTO A IVA: " + afecto);
				System.out.println("- PRECIO DE COMPRA: " + precioCompra);
				System.out.println("- PRECIO DE VENTA: " + precioVenta);
				System.out.println("- CANTIDAD: " + cantidad);
				System.out.println();
				
			}
			
			
		} catch (SQLException e) {

		}

	}
}
*/