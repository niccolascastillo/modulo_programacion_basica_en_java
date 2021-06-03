package posventas;

public class Operador {
	String idOperador;
	String nombre;
	String apellido;
	String email;
	
	
	public Operador(String idOperador, String nombre, String apellido, String email) {
		super();
		this.idOperador = idOperador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}


	public String getIdOperador() {
		return idOperador;
	}


	public void setIdOperador(String idOperador) {
		this.idOperador = idOperador;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Operador [nombre = " + nombre + ", apellido = " + apellido+"]";
	}


	
}
