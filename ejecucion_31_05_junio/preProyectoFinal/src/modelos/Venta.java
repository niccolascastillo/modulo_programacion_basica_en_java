package modelos;

import java.util.Date;

public class Venta {
	
	Long idVenta;
	Date fechaVenta;
	double valorVenta;
	
	
	public Venta(Long idVenta, Date fechaVenta, double valorVenta) {
		super();
		this.idVenta = idVenta;
		this.fechaVenta = fechaVenta;
		this.valorVenta = valorVenta;
	}


	public Long getIdVenta() {
		return idVenta;
	}


	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}


	public Date getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	
	public double getValorVenta() {
		return valorVenta;
	}

	public void setValorVenta(double valorVenta) {
		this.valorVenta = valorVenta;
	}
	
	

	

}
