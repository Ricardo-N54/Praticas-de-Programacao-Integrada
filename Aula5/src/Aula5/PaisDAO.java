package Aula5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaisDAO {

	public Connection obtemConexao() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/cadastro?serverTimezone=UTC&useLegacyDatetimeCode=false", "root",
				"@54321");
	}

	public void criar(Pais p) {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getPopulacao());
			stm.setDouble(3, p.getArea());
			stm.execute();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Pais carregar(int id) {
		Pais p = new Pais();
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.nome = ?";
		
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					String s = rs.getString("nome");
					Long l = rs.getLong("populacao");
					Double a = rs.getDouble("area");

					p.setNome(s);
					p.setArea(a);
					p.setPopulacao(l);
				} else {
					p.setId(-1);
					p.setNome(null);
					p.setPopulacao(0);
					p.setArea(0.0);
				}
				conn.close();
				return p;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return p;
	}

	public Pais maiorPopulacao() {
		Pais p = new Pais();
		String sqlSelect = "select * from Pais ORDER BY populacao DESC LIMIT 1";
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					String s = rs.getString("nome");
					Long l = rs.getLong("populacao");
					Double a = rs.getDouble("area");

					p.setNome(s);
					p.setArea(a);
					p.setPopulacao(l);
				} else {
					p.setId(-1);
					p.setNome(null);
					p.setPopulacao(0);
					p.setArea(0.0);
				}
				conn.close();
				return p;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return p;
	}

	public Pais menorArea() {
		Pais p = new Pais();
		String sqlSelect = "select * from Pais ORDER BY area ASC LIMIT 1";
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					String s = rs.getString("nome");
					Long l = rs.getLong("populacao");
					Double a = rs.getDouble("area");

					p.setNome(s);
					p.setArea(a);
					p.setPopulacao(l);
				} else {
					p.setId(-1);
					p.setNome(null);
					p.setPopulacao(0);
					p.setArea(0.0);
				}
				conn.close();
				return p;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return p;
	}

	public ArrayList<String> vetorTresPaises() {
		ArrayList<String> rety = new ArrayList<String>();
		String sqlSelect = "select * from Pais ORDER BY area ASC LIMIT 3";
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				int k = 0;
				while (k < 3) {
					if (rs.next()) {
						String s = rs.getString("nome");
						rety.add(s);
					} else {
						rety.add(null);
					}
					k++;
				}

				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return rety;
	}

	public void atualizar(Pais p) {
		String sqlUpdate = "UPDATE Pais SET nome=?, populacao=?, area=? WHERE id=?";
		
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, p.getNome());
			stm.setLong(2, p.getPopulacao());
			stm.setDouble(3, p.getArea());
			stm.setInt(4, p.getId());
			stm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void excluir(Pais p) {
		String sqlDelete = "DELETE FROM Pais WHERE id = ?";
		
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, p.getId());
			stm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void truncate() {
		String sqlDelete = "Truncate Pais";
		
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Pais> listarTodos() {
		ArrayList<Pais> paises = new ArrayList<>();
		String sqlSelect = "SELECT id, nome, populacao, area FROM Pais";
		Pais pais;

		try (Connection conn = obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);
				ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					paises.add(pais);
				} 
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return paises;
	}
}
