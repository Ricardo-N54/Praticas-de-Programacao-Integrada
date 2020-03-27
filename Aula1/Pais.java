package Aula1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Pais {
	private int id;
	private String nome;
	private long populacao;
	private double area;

	public Pais(int id, String nome, long populacao, double area) {
		this.id = id;
		this.nome = nome;
		this.populacao = populacao;
		this.area = area;
	}

	public Pais() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPopulacao() {
		return populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", populacao=" + populacao + ", area=" + area + "]";
	}

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

		return DriverManager.getConnection("jdbc:mysql://localhost:3306/cadastro?serverTimezone=UTC&useLegacyDatetimeCode=false", "root", "@54321");
	}

	public void criar() {
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, getNome());
			stm.setLong(2, getPopulacao());
			stm.setDouble(3, getArea());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Pais carregar() {
		Pais p = new Pais(id, nome, populacao, area);
		String sqlSelect = "SELECT nome, populacao, area FROM pais WHERE pais.nome = ?";
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setString(1, getNome());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));

					String s = rs.getString("nome");
					Long l = rs.getLong("populacao");
					Double a = rs.getDouble("area");

					p.setNome(s);
					p.setArea(a);
					p.setPopulacao(l);
					return p;
					
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(0);
					setArea(0.0);
					
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

	public String MaiorPopulacao() {
		String nome = null;
		String sqlSelect = "select * from Pais ORDER BY populacao DESC LIMIT 1";
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));

					nome = rs.getString("nome");
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(0);
					setArea(0.0);
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return nome;
	}
	public String MenorArea() {
		String nome = null;
		String sqlSelect = "select * from Pais ORDER BY area ASC LIMIT 1";
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					setNome(rs.getString("nome"));
					setPopulacao(rs.getLong("populacao"));
					setArea(rs.getDouble("area"));
					nome = rs.getString("nome");
				} else {
					setId(-1);
					setNome(null);
					setPopulacao(0);
					setArea(0.0);
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return nome;
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

						setNome(rs.getString("nome"));
						setPopulacao(rs.getInt("populacao"));
						setArea(rs.getDouble("area"));

						rety.add(s);
					} else {
						setId(-1);
						setNome(null);
						setPopulacao(0);
						setArea(0.0);
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
	public void excluir() {
		String sqlDelete = "DELETE FROM Pais WHERE id = ?";
		try (Connection conn = obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, getId());
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
	
}