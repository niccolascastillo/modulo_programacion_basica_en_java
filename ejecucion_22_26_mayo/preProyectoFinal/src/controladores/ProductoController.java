package controladores;

import java.util.HashMap;
import java.util.Map;

import posventas.Producto;

public class ProductoController {
	static Map<String, Producto> productos = new HashMap<String, Producto>();
	
	public String agregarProducto(String id, String nombre, String descripcion, String tipo, String afecto, double precioCompra, double precioVenta, int cantidad) {
		productos.put(id, new Producto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad));
		return "Producto ingresado correctamente";
	}
	

	public Producto buscarProducto(String id) {
		// TODO Auto-generated method stub
		return productos.get(id);
	}

}
