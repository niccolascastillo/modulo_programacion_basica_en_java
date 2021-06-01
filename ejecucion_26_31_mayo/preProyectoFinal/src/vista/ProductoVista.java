package vista;

public class ProductoVista {

	public void imprimirVistaProducto(String productoId, String productoNombre, String productoDescripcion, String productoTipo, String productoAfecto, double productoPrecioCompra, double productoPrecioVenta, int productoCantidad) {
		System.out.println();
		System.out.println("Datos del producto");
		System.out.println("ID: " + productoId);
		System.out.println("Nombre: " + productoNombre);
		System.out.println("Descripción: " + productoDescripcion);
		System.out.println("Tipo: " + productoTipo);
		System.out.println("Afecto a IVA: " + productoAfecto);
		System.out.println("Precio de compra: " + productoPrecioCompra);
		System.out.println("Precio de Venta: " + productoPrecioVenta);
		System.out.println("Cantidad: " + productoCantidad);
		System.out.println();
	}
}
