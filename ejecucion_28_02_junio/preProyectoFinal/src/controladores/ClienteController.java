package controladores;

import java.util.HashMap;
import java.util.Map;
import posventas.Cliente;


public class ClienteController {
	static Map<String, Cliente> clientes = new HashMap<String, Cliente>();
	
	
	public String agregarCliente(String rut, String nombre, String apellido) {
		clientes.put(rut, new Cliente(rut, nombre, apellido));
		return "CLIENTE INGRESADO CORRECTAMENTE";
	}

	public Cliente buscarCliente(String rut) {
		return clientes.get(rut);
	}
	
	public Cliente removerCliente(String rut) {
		return clientes.remove(rut);
	}
	
	public String actualizarCliente(String rut, String nombre, String apellido) {
		Cliente anterior = buscarCliente(rut);
		anterior.setRut(rut);
		anterior.setNombre(nombre);
		anterior.setApellido(apellido);
		return "CLIENTE MODIFICADO CORRECTAMENTE";
	}
}
