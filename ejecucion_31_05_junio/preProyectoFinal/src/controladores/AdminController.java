package controladores;

import java.util.HashMap;
import java.util.Map;

import modelos.Operador;


public class AdminController {
	static Map<String, Operador> operadores = new HashMap<String, Operador>();

	
	public String agregarOperador(String idOperador, String nombre, String apellido, String password, boolean privilegios) {
		operadores.put(idOperador,  new Operador(idOperador, nombre, apellido, password, privilegios));
		return "NUEVO OPERADOR AÑADIDO";
	}
	
	public Operador buscarOperador(String idOperador) {
		// TODO Auto-generated method stub
		return operadores.get(idOperador);
	}
	
	public void modificarOperador(String idOperador, String nombre, String apellido, String email, String password, boolean privilegios) {
		Operador nuevoOp = buscarOperador(idOperador);
		nuevoOp.setNombre(nombre);
		nuevoOp.setApellido(apellido);
		nuevoOp.setPassword(password);
		nuevoOp.setPrivilegios(privilegios);
	}
	
	public Operador eliminarOperador(String idOperador, String nombre, String apellido, String password, boolean privilegios) {
		return operadores.remove(idOperador);
	}
		
	
	
}