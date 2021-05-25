package posventas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Producto> productos = new HashMap<Integer, Producto>();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Creando el primer producto");
		int valor = teclado.nextInt();
		Producto p = new Producto();
		p.crearProducto(productos);
		}
	}


