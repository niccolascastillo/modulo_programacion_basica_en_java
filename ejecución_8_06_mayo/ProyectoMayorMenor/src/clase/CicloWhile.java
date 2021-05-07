package clase;

import java.util.Scanner;

public class CicloWhile {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese un número: ");
		int n = lector.nextInt();
		int factorial = 1;
		int contador = 0;

		while (contador < n) { 
			contador++;
			if (contador == n) {
				System.out.print(contador+" = "+n+"!");
			} else {
				System.out.print(contador+" x ");
			}
			factorial = factorial * contador;

			
		}
		System.out.println("");
		System.out.println("El resultado del factorial es: "+factorial);
		lector.close();
		}
		
	}

