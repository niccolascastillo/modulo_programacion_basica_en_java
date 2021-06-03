package controladores;

import java.util.HashMap;
import java.util.Map;

import posventas.Operador;


public class AdminController {
	static Map<String, Operador> operadores = new HashMap<String, Operador>();

	
	public void agregarOperador(String idOperador, String nombre, String apellido, String email) {
		operadores.put(idOperador,  new Operador(idOperador, nombre, apellido, email));
	
	}
}