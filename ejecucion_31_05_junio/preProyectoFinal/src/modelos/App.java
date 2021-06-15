package modelos;

import controladores.OperadorController;
import controladores.ProductoController;
import dao.DAOException;
import database.ConexionMySQL;

import java.sql.Connection;
import java.util.Scanner;

public class App {
static Scanner teclado1 = new Scanner(System.in);
static Scanner teclado2= new Scanner(System.in);

public static void main(String[] args) throws DAOException {
	
	Connection conn = ConexionMySQL.getConnection();
	verificarOperador();
}
	
	public static void verificarOperador() throws DAOException {

		String idOperador, password;
		boolean verificador = false;
		System.out.println("--- VERIFICACIÓN DE ACCESO ---");
		
		do {
			idOperador = capturarCadenaTexto("- INGRESE SU ID DE OPERADOR: ");
			password = capturarCadenaTexto("- INGRESE SU PASSWORD DE OPERADOR: ");
			boolean op = new OperadorController().validarOperador(idOperador, password);

			if (op == true) {
				System.out.println("¡Ha ingresado un ID válido!. ");
				verificador = true;
			} else {
				System.out.println("El ID ya está en uso.");
				verificador = false;
			}
		} while (verificador == false);
		
		
	}	


	
		
		
		//crearProducto();
		//eliminarProducto();
		//modificarProducto();
		//revisarInventario();
		//visualizarProducto();
	
		
	
	public static void crearProducto() throws DAOException {
		String id, nombre, descripcion, tipo, afecto;
		int cantidad;
		double precioCompra, precioVenta;
		int verificador = 0;
		System.out.println("--- 1. CREAR PRODUCTO ---");
		

		do {
			id = capturarCadenaTexto("- Ingrese el número de ID del producto: ");
			Producto p = new ProductoController().buscarProducto(id);

			if (p == null) {
				System.out.println("¡Ha ingresado un ID válido!. ");
				verificador = 1;
			} else {
				System.out.println("El ID ya está en uso.");
				verificador = 0;
			}
		} while (verificador == 0);
		
		
		nombre = capturarCadenaTexto("- Ingrese el NOMBRE para el nuevo producto: ");
		descripcion = capturarCadenaTexto("- Ingrese la DESCRIPCIÓN del nuevo producto: ");
		tipo = capturarCadenaTexto("- Ingrese el TIPO de producto: ");
		boolean cualquiera;		
		
		do {
			afecto = capturarCadenaTexto("- ¿Producto AFECTO a IVA? [- S -] o [- N -]: ");
			cualquiera = false;
			
			if (afecto.equalsIgnoreCase("S")) {
				System.out.println("Usted ha eleccionado - S -");
				cualquiera = true;
			}
			if (afecto.equalsIgnoreCase("N")) {
				System.out.println("Usted ha eleccionado - N -");
				cualquiera = true;
			}
			
		} while (cualquiera == false);

		
		do {
			precioCompra = capturarNumeroReal("- Ingrese el PRECIO DE COMPRA para el producto: ");

			if (precioCompra <= 0) {
				System.out.println("El precio de compra no puede ser menor o igual a 0. ");
			}
		} while (precioCompra <= 0);
		
		
		do {
			precioVenta = capturarNumeroReal("- Ingrese el PRECIO DE VENTA para el producto: ");

			if (precioVenta <= 0) {
				System.out.println("El precio de venta no puede ser menor o igual a 0. ");
			}

			if (precioVenta <= precioCompra) {
				System.out.println("El precio de venta no puede ser menor o igual al precio de compra. ");
				precioVenta = 0;
			}
		} while (precioVenta <= 0);
		
		
		do {
			cantidad = capturarNumeroEntero("- Ingrese la CANTIDAD para el producto: ");

			if (cantidad <= 0) {
				System.out.println("Debe ingresar una cantidad positiva válida. ");
			}
		} while (cantidad <= 0);
		
		
		new ProductoController().agregarProducto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad);

	}
		
	public static void eliminarProducto() throws DAOException {
		System.out.println("--- 2. ELIMINAR PRODUCTO ---");
		String id, q;
		int validador = 0;

		do {
			id = capturarCadenaTexto("Ingrese el número de ID del producto: ");
		
			Producto p = new ProductoController().buscarProducto(id);
			q = new ProductoController().mostrarProducto(id);
			
			if (p == null) {
				new ProductoController().removerProducto(id);
				System.out.println("Se ha eliminado el producto: "+q);
				validador = 1;


			} else {
				System.out.println("No se ha encontrado ningún producto con el ID especificado.");
				validador = 0;
			}
		} while (validador == 0);
	} 
	
	public static void modificarProducto() throws DAOException {
		String id, nombre, descripcion, tipo, afecto;
		int cantidad;
		double precioCompra, precioVenta;
		int verificador = 0;
		
		System.out.println("--- 3. MODIFICAR PRODUCTO ---");
		
		do {
			id = capturarCadenaTexto("- Ingrese el número de ID del Producto: ");
			Producto p = new ProductoController().buscarProducto(id);
			
			if (p != null) {
				System.out.println("Ha seleccionado el producto: "+p);
				verificador = 1;
			} else {
				System.out.println("Por favor seleccione un producto válido.");
				verificador = 0;
			}
		} while (verificador == 0);
		
		System.out.println("- Reingrese los datos del producto ");
		
		
		nombre = capturarCadenaTexto("- Reingrese el nombre para el nuevo producto: ");
		descripcion = capturarCadenaTexto("- Reingrese la descripción del nuevo producto: ");
		tipo = capturarCadenaTexto("- Reingrese el tipo de producto: ");
		boolean cualquiera;		
		
		do {
			afecto = capturarCadenaTexto("- Producto afecto a IVA [- S -] o [- N -]: ");
			cualquiera = false;
			
			if (afecto.equalsIgnoreCase("S")) {
				System.out.println("Seleccionó - S -");
				cualquiera = true;
			}
			if (afecto.equalsIgnoreCase("N")) {
				System.out.println("Seleccionó - N -");
				cualquiera = true;
			}
			
		} while (cualquiera == false);

		
		do {
			precioCompra = capturarNumeroReal("- Reingrese el precio de compra para el producto: ");

			if (precioCompra <= 0) {
				System.out.println("El precio de compra no puede ser menor o igual a 0. ");
			}
		} while (precioCompra <= 0);
		
		
		do {
			precioVenta = capturarNumeroReal("- Reingrese el precio de venta para el producto: ");

			if (precioVenta <= 0) {
				System.out.println("El precio de compra no puede ser menor o igual a 0. ");
			}

			if (precioVenta <= precioCompra) {
				System.out.println("El precio de venta no puede ser menor o igual al precio de compra. ");
				precioVenta = 0;
			}
		} while (precioVenta <= 0);
		
		
		do {
			cantidad = capturarNumeroEntero("- Reingrese la cantidad para el producto: ");

			if (cantidad <= 0) {
				System.out.println("Debe ingresar una cantidad positiva válida. ");
			}
		} while (cantidad <= 0);
		
		new ProductoController().actualizarProducto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad);

	}
	
	public static void revisarInventario() throws DAOException {
		System.out.println("--- 4. INVENTARIO DE PRODUCTOS ---");
		
		new ProductoController().mostrarInventario();
	} 
	
	public static void visualizarProducto() throws DAOException {
		String id;
		int verificador = 0;
		
		do {
			id = capturarCadenaTexto("-- Ingrese el número de ID del Producto --");
			Producto p = new ProductoController().buscarProducto(id);
			
			if (p != null) {
				new ProductoController().mostrarProducto(id);
				verificador = 1;
			} else {
				System.out.println("Por favor seleccione un producto válido.");
				verificador = 0;
			}
		} while (verificador == 0);
		
		System.out.println();
	}
	
	
		

	public static String capturarCadenaTexto(String mensaje) {
		String cadena;

		while (true) {
			System.out.print(mensaje);
			cadena = teclado1.nextLine();

			if (!cadena.isEmpty()) {
				return cadena;
			}
			System.out.println("El campo está vacío, por favor ingrese el o los datos solicitados");
		}
	}
		

	public static double capturarNumeroReal(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				return Double.parseDouble(teclado2.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ingrese un número válido");
			}
		}
	}
	
	public static int capturarNumeroEntero(String mensaje) {
		while (true) {
			try {
				System.out.print(mensaje);
				return Integer.parseInt(teclado2.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Ingrese un número entero válido");
			}

		}	}
	

}
