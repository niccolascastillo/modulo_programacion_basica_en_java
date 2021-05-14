package main;

import java.util.Scanner;

public class Ejecucion_9 {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		System.out.println("Ingrese un número: ");
		int n = read.nextInt();
		int contador = 0;
		if (n > 0) {
		for (int i = 2; i <= n; i+=2) {
			contador++;
		}
		} else {
			for (int i = 2; i >= n; i-=2) {
				contador++;
				}
					}
		System.out.println("Entre el numero 2 y el numero "+n+" existen "+contador+" numeros pares");
		read.close();
	}

}
