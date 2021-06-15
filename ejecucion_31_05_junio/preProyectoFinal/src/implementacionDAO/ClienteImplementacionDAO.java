package implementacionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ClienteDAO;
import dao.DAOException;
import modelos.Cliente;

public class ClienteImplementacionDAO implements ClienteDAO {
	
	final String INSERT = "INSERT INTO clientes(rut, nombre, apellido) VALUES (?, ?, ?)";
	final String UPDATE = "UPDATE clientes SET nombre = ?, apellido = ? WHERE rut = ?";
	final String DELETE = "DELETE FROM clientes WHERE rut = ?";
	final String GETALL = "SELECT rut, nombre, apellido FROM clientes";
	final String GETONE = "SELECT rut, nombre, apellido FROM clientes WHERE rut = ? ";
	
	private Connection conn; 
	
	public ClienteImplementacionDAO(Connection conn) {
		this.conn = conn;
	}
	

	public void insertar(Cliente a) throws DAOException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(INSERT);
			ps.setString(1, a.getRut());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellido());
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

	public void modificar(Cliente a) throws DAOException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(UPDATE);
			ps.setString(1, a.getNombre());
			ps.setString(2, a.getApellido());
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

	public void eliminar(Cliente a) throws DAOException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(DELETE);
			ps.setString(1,  a.getRut());
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
	
	
	private Cliente convertir (ResultSet rs) throws SQLException {
		String rut = rs.getString("rut");
		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");
		Cliente operador = new Cliente(rut, nombre, apellido);
		operador.setRut(rs.getString("rut"));
		return operador;
	}
	

	public List<Cliente> obtenerTodos() throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Cliente> listaclientes = new ArrayList<>();
		try {
			ps = conn.prepareStatement(GETALL);
			rs = ps.executeQuery();
			while (rs.next()) {
				listaclientes.add(convertir(rs));
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
		return listaclientes;
	}

	public Cliente obtener(String rut) throws DAOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente a = null;
		try {
			ps = conn.prepareStatement(GETONE);
			ps.setString(1, rut);
			rs = ps.executeQuery();
			if (rs.next()) {
				a = convertir(rs);
			} else {
				throw new DAOException("No se ha encontrado el registro");
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


}