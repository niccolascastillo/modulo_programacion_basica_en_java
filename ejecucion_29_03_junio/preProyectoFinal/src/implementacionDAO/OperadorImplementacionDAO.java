package implementacionDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOException;
import dao.OperadorDAO;
import modelos.Operador;

public class OperadorImplementacionDAO implements OperadorDAO {
	
	final String INSERT = "INSERT INTO operadores(idOperador, nombre, apellido, password, privilegios) VALUES (?, ?, ?, ?, ?)";
	final String UPDATE = "UPDATE operadores SET nombre = ?, apellido = ?, password = ?, privilegios = ? WHERE idOperador = ?";
	final String DELETE = "DELETE FROM operadores WHERE idOperador = ?";
	final String GETALL = "SELECT idOperador, nombre, apellido, privilegios FROM operadores";
	final String GETONE = "SELECT idOperador, nombre, apellido privilegios FROM operadores WHERE idOperador = ? ";
	
	private Connection conn; 
	
	public OperadorImplementacionDAO(Connection conn) {
		this.conn = conn;
	}
	


	public void insertar(Operador a) throws DAOException {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(INSERT);
			ps.setString(1, a.getIdOperador());
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellido());
			ps.setString(4, a.getPassword());
			ps.setBoolean(5, a.getPrivilegios());
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

	public void modificar(Operador a) throws DAOException  {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(UPDATE);
			ps.setString(2, a.getNombre());
			ps.setString(3, a.getApellido());
			ps.setString(4, a.getPassword());
			ps.setBoolean(5, a.getPrivilegios());
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

	public void eliminar(Operador a) throws DAOException  {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(DELETE);
			ps.setString(1,  a.getIdOperador());
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

	
	private Operador convertir (ResultSet rs) throws SQLException {
		String idOperador = rs.getString("idOperador");
		String nombre = rs.getString("nombre");
		String apellido = rs.getString("apellido");
		String password = rs.getString("password");
		boolean privilegios = rs.getBoolean("privilegios");
		Operador operador = new Operador(idOperador, nombre, apellido, password, privilegios);
		operador.setIdOperador(rs.getString("id"));
		return operador;
	}
	
	
	public List<Operador> obtenerTodos() throws DAOException  {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Operador> listaoperadores = new ArrayList<>();
		try {
			ps = conn.prepareStatement(GETALL);
			rs = ps.executeQuery();
			while (rs.next()) {
				listaoperadores.add(convertir(rs));
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
		return listaoperadores;
	}

	
	public Operador obtener(String idOperador) throws DAOException  {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Operador a = null;
		try {
			ps = conn.prepareStatement(GETONE);
			ps.setString(1, idOperador);
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