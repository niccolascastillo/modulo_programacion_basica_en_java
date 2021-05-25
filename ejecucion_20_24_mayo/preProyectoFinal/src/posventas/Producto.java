package posventas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Producto {

	int id;
	String nombre;
	String descripcion;
	String tipo;
	String afecto;
	double precioCompra;
	double precioVenta;
	int cantidad;

	
	public Producto() {
	}
	
	public Producto(int id, String nombre, String descripcion, String tipo, String afecto, double precioCompra,
			double precioVenta, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.afecto = afecto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidad = cantidad;
	}

	Map<Integer, Producto> productos = new HashMap<Integer, Producto>();
	static Scanner teclado = new Scanner(System.in);
	
	
		
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

	public String getAfecto() {
		return afecto;
	}

	public void setAfecto(String afecto) {
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
	
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

	
	
	
	
	public Producto crearProducto(Map<Integer, Producto> productos) {
		System.out.println("-- 1. Crear Producto --");
		Producto product;

		
		do {
			id = capturarNumeroEntero("Ingrese el número de ID del producto");

			if (id <= 0) {
				System.out.println("Debe ingresar un número de ID positivo");

			} 
			if (productos.get(id) != null) {
				System.out.println("Ya existe un producto con ese ID");
				id = 0;

			}
		} while (id <= 0);
		
		
		nombre = capturarCadenaTexto("Ingrese el nombre para el nuevo producto");
		descripcion = capturarCadenaTexto("Digite la descripción del nuevo producto");
		tipo = capturarCadenaTexto("Ingrese el tipo de producto");
		
		
		do {
			afecto = capturarCadenaTexto("Ingrese - S - si el producto está afecto a IVA, ingrese - N - si no está afecto a IVA");
			
			if (afecto != "S" | afecto != "N" ) {
				System.out.println("Debe seleccionar alguna de las opciones");
				
			} else if (afecto == "S" | afecto °= "N");
				break;
			}
			
		} while (afecto != "S" | afecto != "N");
		
		
		do {
			precioCompra = capturarNumeroReal("Ingrese el precio de compra para el producto");

			if (precioCompra <= 0) {
				System.out.println("El precio de compra no puede ser menor o igual a 0");
			}
		} while (precioCompra <= 0);
		
		
		do {
			precioVenta = capturarNumeroReal("Ingrese el precio de venta para el producto");

			if (precioVenta <= 0) {
				System.out.println("El precio de compra no puede ser menor o igual a 0");
			}

			if (precioVenta <= precioCompra) {
				System.out.println("El precio de venta no puede ser menor o igual al precio de compra");
				precioVenta = 0;
			}
		} while (precioVenta <= 0);
		
		
		do {
			cantidad = capturarNumeroEntero("Ingrese la cantidad para el producto");

			if (cantidad <= 0) {
				System.out.println("Debe ingresar una cantidad positiva válida");
			}
		} while (cantidad <= 0);
		
		
		//return new Producto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad);	//
		product = new Producto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad);
		return productos.put(id, product);
	}
		
	
	
		
	public static String capturarCadenaTexto(String mensaje) {
		String cadena;

		while (true) {
			System.out.println(mensaje);
			cadena = teclado.nextLine();

			if (!cadena.isEmpty()) {
				return cadena;
			}
			System.out.println("El campo está vacío, por favor ingrese el o los datos solicitados");
		}
	}
		

	public double capturarNumeroReal(String mensaje) {
		while (true) {
			try {
				System.out.println(mensaje);
				return Double.parseDouble(teclado.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ingrese un número válido");
			}
		}
	}
	
	public int capturarNumeroEntero(String mensaje) {
		while (true) {
			try {
				System.out.println(mensaje);
				return Integer.parseInt(teclado.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ingrese un número entero válido");
			}

		}
	}
}
