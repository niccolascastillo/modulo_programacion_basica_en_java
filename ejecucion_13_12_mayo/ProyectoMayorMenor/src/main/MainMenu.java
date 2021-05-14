package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {

		String menu = "1. Validar si es un numero impar\r\n" +
				"2. Validar si es un numero es primo\r\n" +
				"3. Contar los numeros primos entre el 2 y el numero ingresado\r\n" +
				"4. Salir";
		// System.out.println(menu);
		Scanner sc = new Scanner(System.in);
		int opcion=0;

		System.out.println("Bienvenido al programa!");
		while(opcion != 4) {
			System.out.println(menu);
			System.out.println(" ");
			System.out.print("Ingresa la opción: ");
			System.out.println(" ");
			opcion = sc.nextInt();
			if (opcion == 1) {
				System.out.println("Ingresa un número entero: ");
				int numero = sc.nextInt();
				comprobarPar(numero);
			}
			else if(opcion == 2){
				System.out.println("Ingresa un número entero: ");
				int numeroPrimo = sc.nextInt();
				esPrimo(numeroPrimo);
				if(esPrimo(numeroPrimo)) {
					System.out.println("El número: " + numeroPrimo + " es primo");
					System.out.println(" ");
				} else {
					System.out.println("El número: " + numeroPrimo + " no es primo");
					System.out.println(" ");
				};
			}
			else if (opcion == 3) {
				System.out.println("Ingresa un número entero: ");
				int primosContados = sc.nextInt();
				contarPrimos(primosContados);
			}
		}
		System.out.println("Fin del programa!");
		sc.close();
	}

	public static void comprobarPar(int numero) {
		if (numero % 2 == 0) {
			System.out.println("El número: " + numero + " no es impar.");
			System.out.println(" ");
		} else {
			System.out.println("El número: " + numero + " es impar.");
			System.out.println(" ");
		}

	}
	public static boolean esPrimo(int numero){
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != numero)){
			if (numero % contador == 0)
				primo = false;
			contador++;
		}

		return primo;
	}
	public static void contarPrimos(int numero) {
		List<Integer> numerosPrimos = new ArrayList<Integer>();
		int countPrimos=0;
		for (int i = 2; i <= numero; i++) {
			if (esPrimo(i)) {
				countPrimos++;
				numerosPrimos.add(i);
			}
			// System.out.print(i + " ");
		}
		System.out.println("Existen: "+ countPrimos+ " números primos");
		System.out.println(numerosPrimos);
		System.out.println(" ");
	}

}