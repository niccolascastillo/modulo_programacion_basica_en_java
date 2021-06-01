package controladores;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import posventas.Producto;


public class ProductoController {
	static Map<String, Producto> productos = new HashMap<String, Producto>();
	
	

	public String agregarProducto(String id, String nombre, String descripcion, String tipo, String afecto, double precioCompra, double precioVenta, int cantidad) {
		productos.put(id, new Producto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad));
		return "Producto ingresado correctamente";
	}
	
	public String actualizarProducto(String id, String nombre, String descripcion, String tipo, String afecto, double precioCompra, double precioVenta, int cantidad) {
		Producto anterior = buscarProducto(id);
		anterior.setNombre(nombre);
		anterior.setDescripcion(descripcion);
		anterior.setTipo(tipo);
		anterior.setAfecto(afecto);
		anterior.setPrecioCompra(precioCompra);
		anterior.setPrecioVenta(precioVenta);
		anterior.setCantidad(cantidad);
		return "Producto actualizado correctamente";
		
	}
		
	public Producto buscarProducto(String id) {
		// TODO Auto-generated method stub
		return productos.get(id);
	}
	
	
	public Producto removerProducto(String id) {
		return productos.remove(id);
	}
	
	
	public void mostrarProducto(String id) {
		Producto mostrar = buscarProducto(id);
		System.out.println();
		System.out.println("Datos del producto");
		System.out.println("ID: " + mostrar.getId());
		System.out.println("Nombre: " + mostrar.getNombre());
		System.out.println("Descripción: " + mostrar.getDescripcion());
		System.out.println("Tipo: " + mostrar.getTipo());
		System.out.println("Afecto a IVA: " + mostrar.getAfecto());
		System.out.println("Precio de compra: " + mostrar.getPrecioVenta());
		System.out.println("Precio de Venta: " + mostrar.getPrecioVenta());
		System.out.println("Cantidad: " + mostrar.getCantidad());
		System.out.println();
	}
	
	public void mostrarInventario() {
		for (Map.Entry<String, Producto> entry : productos.entrySet()) {
		    System.out.println(entry.getKey()+" = "+entry.getValue());
		}
	}
}
	
