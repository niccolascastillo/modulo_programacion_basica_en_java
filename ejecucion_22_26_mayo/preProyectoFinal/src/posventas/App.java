package posventas;

import java.util.Map;
import java.util.Scanner;
import controladores.ProductoController;

public class App {
static Scanner teclado1 = new Scanner(System.in);
static Scanner teclado2= new Scanner(System.in);

	public static void main(String[] args) {
		crearProducto();
		}
	
	
	public static void crearProducto() {
		int cantidad;
		String id, nombre, descripcion, tipo, afecto;
		double precioCompra, precioVenta;
		int verificador = 0;
		System.out.println("-- 1. Crear Producto --");
		

		do {
			id = capturarCadenaTexto("- Ingrese el n�mero de ID del producto: ");
			Producto p = new ProductoController().buscarProducto(id);

			if (p != null) {
				System.out.println("Ya existe un producto con ese ID. ");
				verificador = 0;
			} else {
				System.out.println("ID v�lido");
				verificador = 1;
			}
		} while (verificador <= 0);
		
		
		nombre = capturarCadenaTexto("- Ingrese el nombre para el nuevo producto: ");
		descripcion = capturarCadenaTexto("- Ingrese la descripci�n del nuevo producto: ");
		tipo = capturarCadenaTexto("- Ingrese el tipo de producto: ");
		
		boolean cualquiera = true;
		
		do {
			afecto = capturarCadenaTexto("- Producto afecto a IVA [- S -] o [- N -]: ");
			
			
			if (afecto.equalsIgnoreCase("S")) {
				//System.out.println("Seleccion� - S -");
				cualquiera = false;
			}
			if (afecto.equalsIgnoreCase("N")) {
				//System.out.println("Seleccion� - N -");
				cualquiera = false;
			}
			
		} while (cualquiera == true);

		
		do {
			precioCompra = capturarNumeroReal("- Ingrese el precio de compra para el producto: ");

			if (precioCompra <= 0) {
				System.out.println("El precio de compra no puede ser menor o igual a 0. ");
			}
		} while (precioCompra <= 0);
		
		
		do {
			precioVenta = capturarNumeroReal("- Ingrese el precio de venta para el producto: ");

			if (precioVenta <= 0) {
				System.out.println("El precio de compra no puede ser menor o igual a 0. ");
			}

			if (precioVenta <= precioCompra) {
				System.out.println("El precio de venta no puede ser menor o igual al precio de compra. ");
				precioVenta = 0;
			}
		} while (precioVenta <= 0);
		
		
		do {
			cantidad = capturarNumeroEntero("- Ingrese la cantidad para el producto: ");

			if (cantidad <= 0) {
				System.out.println("Debe ingresar una cantidad positiva v�lida. ");
			}
		} while (cantidad <= 0);
		
		
		new ProductoController().agregarProducto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad);

	}
		
	
	
		
	public static String capturarCadenaTexto(String mensaje) {
		String cadena;

		while (true) {
			System.out.print(mensaje);
			cadena = teclado1.nextLine();

			if (!cadena.isEmpty()) {
				return cadena;
			}
			System.out.println("El campo est� vac�o, por favor ingrese el o los datos solicitados");
		}
	}
		

	public static double capturarNumeroReal(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				return Double.parseDouble(teclado2.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ingrese un n�mero v�lido");
			}
		}
	}
	
	public static int capturarNumeroEntero(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				return Integer.parseInt(teclado2.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ingrese un n�mero entero v�lido");
			}

		}
	}
	}


