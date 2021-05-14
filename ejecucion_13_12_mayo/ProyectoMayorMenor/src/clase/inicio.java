package clase;

import java.util.Scanner;

public class inicio {

	public static void main(String[] args) {
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese el primer número: ");
		int variable1 = lector.nextInt();
		System.out.println("Ingrese el segundo número: ");
		int variable2 = lector.nextInt();
		System.out.println("Ingrese el tercer número: ");
		int variable3 = lector.nextInt();
		if (variable1 > variable2 && variable2 >variable3) {
			System.out.println("De mayor a menor: "+variable1+", "+variable2+", "+variable3);
			System.out.println("De menor a mayor: "+variable3+", "+variable2+", "+variable1);
		} else if (variable1 > variable3 && variable3 > variable2) {
			System.out.println("De mayor a menor: "+variable1+", "+variable3+", "+variable2);
			System.out.println("De menor a mayor: "+variable2+", "+variable3+", "+variable1);
		} else if (variable2 > variable1 && variable1 > variable3) {
			System.out.println("De mayor a menor: "+variable2+", "+variable1+", "+variable3);
			System.out.println("De menor a mayor: "+variable3+", "+variable1+", "+variable2);
		} else if (variable2 > variable3 && variable3 > variable1) {
			System.out.println("De mayor a menor: "+variable2+", "+variable3+", "+variable1);
			System.out.println("De menor a mayor: "+variable1+", "+variable3+", "+variable2);
		} else if (variable3 > variable1 && variable1 > variable2) {
			System.out.println("De mayor a menor: "+variable3+", "+variable1+", "+variable2);
			System.out.println("De menor a mayor: "+variable2+", "+variable1+", "+variable3);
		} else if (variable3 > variable2 && variable2 > variable1) {
			System.out.println("De mayor a menor: "+variable3+", "+variable2+", "+variable1);
			System.out.println("De menor a mayor: "+variable1+", "+variable2+", "+variable3);
		} else {
			System.out.println("No existe una secuencia clara de Menor-Mayor o Mayor-Menor.");
		}
		lector.close();
	}
	

}