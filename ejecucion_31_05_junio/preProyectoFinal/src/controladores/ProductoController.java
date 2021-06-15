package controladores;

import java.sql.Connection;
import java.util.List;

import dao.DAOException;
import dao.ProductoDAO;
import database.ConexionMySQL;
import implementacionDAO.ProductoImplementacionDAO;
import modelos.Producto;


public class ProductoController {
	
	static Connection conn = ConexionMySQL.getConnection();
	ProductoDAO dao = new ProductoImplementacionDAO(conn);
	

	public void agregarProducto(String id, String nombre, String descripcion, String tipo, String afecto, double precioCompra, double precioVenta, int cantidad) throws DAOException {
		Producto nuevo = new Producto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad);
		dao.insertar(nuevo);
		
	}
	
	public void actualizarProducto(String id, String nombre, String descripcion, String tipo, String afecto, double precioCompra, double precioVenta, int cantidad) throws DAOException {
		Producto nuevo = new Producto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad);
		dao.modificar(nuevo);
		
	}
		
	public Producto buscarProducto(String id) throws DAOException {
		return dao.obtener(id);
	}
	
	
	public void removerProducto(String id) throws DAOException {
		Producto a = buscarProducto(id);
		dao.eliminar(a);
			
	}
	
	
	public String mostrarProducto(String id) throws DAOException {
		Producto mostrar = buscarProducto(id);
		System.out.println();
		System.out.println("--- DATOS DEL PRODUCTO ---");
		System.out.println("- ID: " + mostrar.getId());
		System.out.println("- NOMBRE: " + mostrar.getNombre());
		System.out.println("- DESCRIPCIÓN: " + mostrar.getDescripcion());
		System.out.println("- TIPO: " + mostrar.getTipo());
		System.out.println("- AFECTO A IVA: " + mostrar.getAfecto());
		System.out.println("- PRECIO DE COMPRA: " + mostrar.getPrecioCompra());
		System.out.println("- PRECIO DE VENTA: " + mostrar.getPrecioVenta());
		System.out.println("- CANTIDAD: " + mostrar.getCantidad());
		System.out.println();
		return "Información del producto ID "+mostrar.getId();
	}
	
	public void mostrarInventario() throws DAOException {
		List<Producto> productos = dao.obtenerTodos();
		for (Producto a: productos) {
			System.out.println(a.toString());
		}
	}
}
	
