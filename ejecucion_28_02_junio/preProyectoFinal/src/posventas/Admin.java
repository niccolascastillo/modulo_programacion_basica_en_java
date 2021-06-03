package posventas;



public class Admin extends Operador {
	String idAdmin;
	
	

	public Admin(String idOperador, String nombre, String apellido, String email, String idAdmin) {
		super(idOperador, nombre, apellido, email);
		this.idAdmin = idAdmin;
	}



	public String getIdAdmin() {
		return idAdmin;
	}



	public void setIdAdmin(String idAdmin) {
		this.idAdmin = idAdmin;
	}

	
}
