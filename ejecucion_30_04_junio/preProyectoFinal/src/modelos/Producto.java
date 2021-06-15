package modelos;



public class Producto {

	String id;
	String nombre;
	String descripcion;
	String tipo;
	String afecto;
	double precioCompra;
	double precioVenta;
	int cantidad;


	
	public Producto(String id, String nombre, String descripcion, String tipo, String afecto, double precioCompra,
			double precioVenta, int cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.afecto = afecto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidad = cantidad;
	}
	
		
	public Producto() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAfecto() {
		return afecto;
	}

	public void setAfecto(String afecto) {
		this.afecto = afecto;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [id= " + id + ", nombre= " + nombre + ", descripcion= " + descripcion + ", tipo= " + tipo
				+ ", afecto= " + afecto + ", precioCompra= " + precioCompra + ", precioVenta= " + precioVenta
				+ ", cantidad= " + cantidad + "]";
	}
	
	

	
}
