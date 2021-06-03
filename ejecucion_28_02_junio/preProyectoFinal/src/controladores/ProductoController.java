package controladores;

import java.util.HashMap;
import java.util.Map;
import posventas.Producto;


public class ProductoController {
	static Map<String, Producto> productos = new HashMap<String, Producto>();
	
	

	public String agregarProducto(String id, String nombre, String descripcion, String tipo, String afecto, double precioCompra, double precioVenta, int cantidad) {
		productos.put(id, new Producto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad));
		return "PRODUCTO INGRESADO CORRECTAMENTE";
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
		return "PRODUCTO ACTUALIZADO CORRECTAMENTE";
		
	}
		
	public Producto buscarProducto(String id) {
		// TODO Auto-generated method stub
		return productos.get(id);
	}
	
	
	public Producto removerProducto(String id) {
		return productos.remove(id);
	}
	
	
	public String mostrarProducto(String id) {
		Producto mostrar = buscarProducto(id);
		System.out.println();
		System.out.println("--- DATOS DEL PRODUCTO ---");
		System.out.println("- ID: " + mostrar.getId());
		System.out.println("- NOMBRE: " + mostrar.getNombre());
		System.out.println("- DESCRIPCIÓN: " + mostrar.getDescripcion());
		System.out.println("- TIPO: " + mostrar.getTipo());
		System.out.println("- AFECTO A IVA: " + mostrar.getAfecto());
		System.out.println("- PRECIO DE COMPRA: " + mostrar.getPrecioVenta());
		System.out.println("- PRECIO DE VENTA: " + mostrar.getPrecioVenta());
		System.out.println("- CANTIDAD: " + mostrar.getCantidad());
		System.out.println();
		return "Información del producto ID "+mostrar.getId();
	}
	
	public void mostrarInventario() {
		for (Map.Entry<String, Producto> entry : productos.entrySet()) {
		    System.out.println(entry.getKey()+" = "+entry.getValue());
		}
	}
}
	
