package implementacionDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ClienteDAO;
import dao.DAOException;
import dao.GestorDAO;
import dao.OperadorDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import database.ConexionMySQL;
import modelos.Producto;

public class GestorImplementacionDAO implements GestorDAO {
	
	private Connection conn;
	
	private ProductoDAO productos = null;
	private ClienteDAO clientes = null;
	private OperadorDAO operadores = null;
	private VentaDAO ventas = null;
	
	
	public GestorImplementacionDAO() {
		conn = ConexionMySQL.getConnection();
	}



	public ProductoDAO getProductoDAO() {
		if (productos == null) {
			productos = new ProductoImplementacionDAO(conn);
		}
		return productos;
	}



	public ClienteDAO getClienteDAO() {
		if (clientes == null) {
			clientes = new ClienteImplementacionDAO(conn);
		}
		return clientes;
	}


	public OperadorDAO getOperadorDAO() {
		if (operadores == null) {
			operadores = new OperadorImplementacionDAO(conn);
		}
		return operadores;
	}
	
	
	/*public static void main(String[] args) throws SQLException, DAOException {
		GestorImplementacionDAO ges = new GestorImplementacionDAO();
		List<Producto> productos = ges.getProductoDAO().obtenerTodos();
		System.out.println(productos);
		
	}*/



	@Override
	public VentaDAO getVentaDAO() {
		if (ventas == null) {
			ventas = new VentaImplementacionDAO(conn);
		}
		return ventas;
	}
	
}
