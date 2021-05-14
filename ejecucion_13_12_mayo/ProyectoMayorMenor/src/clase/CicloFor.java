package clase;

import java.util.Scanner;

public class CicloFor {

	public static void main(String[] args) {
		
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese un número: ");
		int n  = lector.nextInt();
		int contador = 0;
		while (n <= 2);
			for (int i = 2; i <= n ; i+=2) {
				System.out.print(i+" ");
				contador++;
		}
		lector.close();
		System.out.println(" ");
		System.out.println("La cantidad de numeros pares contenidos en "+n+" son: "+contador);
	}

}
