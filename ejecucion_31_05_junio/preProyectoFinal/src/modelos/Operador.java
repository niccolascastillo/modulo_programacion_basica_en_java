package modelos;

public class Operador {
	String idOperador;
	String nombre;
	String apellido;
	String password;
	boolean privilegios;
	
	
	public Operador(String idOperador, String nombre, String apellido, String password, boolean privilegios) {
		super();
		this.idOperador = idOperador;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.privilegios = privilegios;
	}



	public Operador() {
		// TODO Auto-generated constructor stub
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean getPrivilegios() {
		return privilegios;
	}
	
	public void setPrivilegios(boolean privilegios) {
		this.privilegios = privilegios;
	}


	@Override
	public String toString() {
		return "Operador [nombre = " + nombre + ", apellido = " + apellido+"]";
	}


	
}
