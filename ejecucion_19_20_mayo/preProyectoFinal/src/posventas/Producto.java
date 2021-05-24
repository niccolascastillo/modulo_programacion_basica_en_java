package posventas;

import java.util.ArrayList;
import java.util.Scanner;


public class Producto {

	private int id;
	private String nombre;
	private String descripcion;
	private String tipo;
	private boolean afecto;
	private double precioCompra;
	private double precioVenta;
	private int cantidad;

	
	public Producto() {
	}

	public Producto(int id, String nombre, String descripcion, String tipo, boolean afecto, double precioCompra, double precioVenta, int cantidad) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.afecto = afecto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidad = cantidad;
	}
	
	ArrayList<Producto> productos = new ArrayList<>();
	Scanner teclado = new Scanner(System.in);
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public boolean getAfecto() {
		return afecto;
	}

	public void setAfecto(boolean afecto) {
		this.afecto = afecto;
	}

	public double getPrecioCompra() {
		return precioCompra;	
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
	public crearProducto(ArrayList<Producto> productos) {
		System.out.println("-- 1. Crear Producto --");
		
		
		
	}
	
}
