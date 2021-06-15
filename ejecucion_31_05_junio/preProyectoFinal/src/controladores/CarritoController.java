package controladores;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dao.ProductoDAO;
import dao.VentaDAO;
import database.ConexionMySQL;
import implementacionDAO.ClienteImplementacionDAO;
import implementacionDAO.ProductoImplementacionDAO;
import implementacionDAO.VentaImplementacionDAO;
import modelos.CarritoCompra;
import modelos.Cliente;
import modelos.Producto;

public class CarritoController {
	
	static Connection conn = ConexionMySQL.getConnection();
	
	Cliente cliente = new Cliente();
	ClienteDAO cldao = new ClienteImplementacionDAO(conn);
	VentaDAO vdao = new VentaImplementacionDAO(conn);
	ProductoDAO prdao = new ProductoImplementacionDAO(conn);
	Producto producto = new Producto();
	
	int articulos = 0;
	int cantidad = 0;
	double subTotal = 0.0;
	double valorTotal = 0.0;
	
	List<CarritoCompra> productoscarrito = new ArrayList<>();
	List productos = new ArrayList<>();
	
	Long idVenta;
	double montopagar;
	String id = "0";
	
	CarritoCompra carr = new CarritoCompra();
	
	

}
