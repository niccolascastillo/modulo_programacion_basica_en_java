package modelos;

public class DetalleVenta {
	
	CarritoCompra carrito;
	double precioVenta;
	double subTotal;
	double total;
	
	
	public DetalleVenta(CarritoCompra carrito, double precioVenta, double subTotal, double total) {
		super();
		this.carrito = carrito;
		this.precioVenta = precioVenta;
		this.subTotal = subTotal;
		this.total = total;
	}


	public CarritoCompra getCarrito() {
		return carrito;
	}


	public void setCarrito(CarritoCompra carrito) {
		this.carrito = carrito;
	}


	public double getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}


	public double getSubTotal() {
		return subTotal;
	}


	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	
	

}
