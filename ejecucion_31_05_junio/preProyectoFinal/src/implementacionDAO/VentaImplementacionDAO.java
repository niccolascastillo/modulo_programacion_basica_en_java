package implementacionDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOException;
import dao.VentaDAO;
import modelos.Venta;

	public class VentaImplementacionDAO implements VentaDAO {

		final String INSERT = "INSERT INTO ventas(fechaVenta, valorVenta) VALUES (?, ?)";
		final String UPDATE = "UPDATE ventas SET fechaVenta = ?, valorVenta = ? WHERE idVenta = ?";
		final String DELETE = "DELETE FROM ventas WHERE idVenta = ?";
		final String GETALL = "SELECT idVenta, fechaVenta, valorVenta FROM ventas";
		final String GETONE = "SELECT idVenta, fechaVenta, valorVenta FROM ventas WHERE idVenta = ? ";
		
		private Connection conn; 
		
		public VentaImplementacionDAO(Connection conn) {
			this.conn = conn;
			
		}
		
		public void insertar(Venta a) throws DAOException {
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement(INSERT);
				ps.setDate(1, (Date) a.getFechaVenta());
				ps.setDouble(2, a.getValorVenta());
				if (ps.executeUpdate() == 0) {
					throw new DAOException("¡Puede que no se haya guardado!");
				} else {
					System.out.println("*** VENTA GENERADA CORRECTAMENTE ***");
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

		public void modificar(Venta a) throws DAOException {
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement(UPDATE);
				ps.setDate(1, (Date) a.getFechaVenta());
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

		public void eliminar(Venta a) throws DAOException {
			PreparedStatement ps = null;
			try {
				ps = conn.prepareStatement(DELETE);
				ps.setLong(1,  a.getIdVenta());
				if (ps.executeUpdate() == 0) {
					throw new DAOException("Puede que no se haya borrado"); 
				} else {
					System.out.println("*** VENTA ELIMINADA CORRECTAMENTE ***");
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

		private Venta convertir (ResultSet rs) throws SQLException {
			Long idVenta = rs.getLong("idVenta");
			Date fechaVenta = rs.getDate("fechaVenta");
			double valorVenta = rs.getDouble("valorVenta");
			Venta venta = new Venta(idVenta, fechaVenta, valorVenta);
			venta.setIdVenta(rs.getLong("idVenta"));
			return venta;
		}
		
		public List<Venta> obtenerTodos() throws DAOException {
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Venta> listaventas = new ArrayList<>();
			try {
				ps = conn.prepareStatement(GETALL);
				rs = ps.executeQuery();
				while (rs.next()) {
					listaventas.add(convertir(rs));
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
			return listaventas;
		}

		public Venta obtener(Long idVenta) throws DAOException {
			PreparedStatement ps = null;
			ResultSet rs = null;
			Venta a = null;
			try {
				ps = conn.prepareStatement(GETONE);
				ps.setLong(1, idVenta);
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
}
