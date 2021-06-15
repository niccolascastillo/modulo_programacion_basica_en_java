package modelos;



public class Admin extends Operador {
	boolean privilegios;
	
	

	public Admin(String idOperador, String nombre, String apellido, String password, boolean privilegios) {
		super(idOperador, nombre, apellido, password, privilegios);
		this.privilegios = privilegios;
	}


	public boolean isPrivilegios() {
		return privilegios;
	}



	public void setPrivilegios(boolean privilegios) {
		this.privilegios = privilegios;
	}



	
}
