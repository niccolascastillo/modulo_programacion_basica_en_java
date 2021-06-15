package implementacionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOException;
import dao.ProductoDAO;
import modelos.Producto;

public class ProductoImplementacionDAO implements ProductoDAO {

	final String INSERT = "INSERT INTO productos(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, Cantidad) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	final String UPDATE = "UPDATE productos SET nombre = ?, descripcion = ?, tipo = ?, afecto = ?, precioCompra = ?, precioVenta = ?, cantidad = ? WHERE id = ?";
	final String DELETE = "DELETE FROM productos WHERE id = ?";
	final String GETALL = "SELECT id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, Cantidad FROM productos";
	final String GETONE = "SELECT id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, Cantidad FROM productos WHERE id = ? ";
	
	private Connection conn; 
	
	public ProductoImplementacionDAO(Connection conn) {
		this.conn = conn;
		
	}
	
	public void insertar(Producto a) throws DAOException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(INSERT);
			ps.setString(1, a.getId());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getDescripcion());
			ps.setString(4, a.getTipo());
			ps.setString(5,  a.getAfecto());
			ps.setDouble(6, a.getPrecioCompra());
			ps.setDouble(7, a.getPrecioVenta());
			ps.setInt(8, a.getCantidad());
			if (ps.executeUpdate() == 0) {
				throw new DAOException("¡Puede que no se haya guardado!");
			} else {
				System.out.println("*** PRODUCTO GUARDADO CORRECTAMENTE ***");
			}
			
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
				
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					throw new DAOException("Error en SQL", ex);
				}
			}
		}
	
	}

	public void modificar(Producto a) throws DAOException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(UPDATE);
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getDescripcion());
			ps.setString(3, a.getTipo());
			ps.setString(4,  a.getAfecto());
			ps.setDouble(5, a.getPrecioCompra());	
			ps.setDouble(6, a.getPrecioVenta());
			ps.setInt(8, a.getCantidad());
			if (ps.executeUpdate() == 0) {
				throw new DAOException("Puede que no se haya guardado");
			}
			
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
				
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					throw new DAOException("Error en SQL", ex);
				}
			}
		}
	
	}

	public void eliminar(Producto a) throws DAOException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(DELETE);
			ps.setString(1,  a.getId());
			if (ps.executeUpdate() == 0) {
				throw new DAOException("Puede que no se haya borrado"); 
			} else {
				System.out.println("*** PRODUCTO ELIMINADO CORRECTAMENTE ***");
			}
			
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
				
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					throw new DAOException("Error en SQL", ex);
				}
			}
		}
	
	}

	private Producto convertir (ResultSet rs) throws SQLException {
		String id = rs.getString("id");
		String nombre = rs.getString("nombre");
		String descripcion = rs.getString("descripcion");
		String tipo = rs.getString("tipo");
		String afecto = rs.getString("afecto");
		double precioCompra = rs.getDouble("precioCompra");
		double precioVenta = rs.getDouble("precioVenta");
		int cantidad = rs.getInt("cantidad");
		Producto producto = new Producto(id, nombre, descripcion, tipo, afecto, precioCompra, precioVenta, cantidad);
		producto.setId(rs.getString("id"));
		return producto;
	}
	
	public List<Producto> obtenerTodos() throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Producto> listaproductos = new ArrayList<>();
		try {
			ps = conn.prepareStatement(GETALL);
			rs = ps.executeQuery();
			while (rs.next()) {
				listaproductos.add(convertir(rs));
			}
				
		} catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
				
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					new DAOException("Error en SQL", ex);
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					new DAOException("Error en SQL", ex);
				}
			}
		}
		return listaproductos;
	}

	public Producto obtener(String id) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto a = null;
		try {
			ps = conn.prepareStatement(GETONE);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				a = convertir(rs);
			}  else {
				return null;
			}
		}catch (SQLException ex) {
			throw new DAOException("Error en SQL", ex);
				
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException ex) {
					new DAOException("Error en SQL", ex);
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException ex) {
					new DAOException("Error en SQL", ex);
				}
			}
		}
		return a;
		
	}
	
	/*public static void main(String[] args) throws SQLException, DAOException {
		Connection conn = null;
		try {
			conn = ConexionMySQL.getConnection();
			ProductoDAO dao = new ProductoImplementacionDAO(conn);
			Producto nuevo = new Producto("2040", "Giant", "Trance 2 27.5", "bicicleta", "S", 560000, 960000, 3);
			dao.insertar(nuevo);
			List<Producto> productos = dao.obtenerTodos();
			for (Producto a: productos) {
				System.out.println(a.toString());
			}
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	} */

}