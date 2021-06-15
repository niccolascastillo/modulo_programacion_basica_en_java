package modelos;



public class Cliente {
	
	String rut;
	String nombre;
	String apellido;

	
	public Cliente(String rut, String nombre, String apellido) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	
	public Cliente() {
	}


	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	@Override
	public String toString() {
		return "Cliente [rut = " + rut + ", nombre = " + nombre + ", apellido = " + apellido + "]";
	}




}
