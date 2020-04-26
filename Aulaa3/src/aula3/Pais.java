package aula3;



//import java.io.Serializable;
//import java.util.ArrayList;

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

//	public void criar() {
//		PaisDAO dao = new PaisDAO();
//		dao.criar(id, nome, populacao, area);
//	}
//
//	public void atualizar() {
//		PaisDAO dao = new PaisDAO();
//		dao.atualizar(id, nome, populacao, area);
//	}
//
//	public void excluir() {
//		PaisDAO dao = new PaisDAO();
//		dao.excluir(id);
//	}
//
//	public Pais carregar() {
//		PaisDAO dao = new PaisDAO();
//		Pais dados = dao.carregar(id);
//		nome = (String) dados.getNome();
//		populacao = (long) dados.getPopulacao();
//		area = (double) dados.getArea();
//		return dados;
//	}
//	
//	public void truncate() {
//		PaisDAO dao = new PaisDAO();
//		dao.truncate();
//	}
//	
//	public Pais maiorPopulacao() {
//		PaisDAO dao = new PaisDAO();
//		Pais dados = dao.maiorPopulacao();
//		nome = (String) dados.getNome();
//		populacao = (long) dados.getPopulacao();
//		area = (double) dados.getArea();
//		return dados;
//	}
//	
//	public Pais menorArea() {
//		PaisDAO dao = new PaisDAO();
//		Pais dados = dao.menorArea();
//		nome = (String) dados.getNome();
//		populacao = (long) dados.getPopulacao();
//		area = (double) dados.getArea();
//		return dados;
//	}
//	
//	public ArrayList<String> vetorTresPaises() {
//		PaisDAO dao = new PaisDAO();
//		ArrayList<String> dados = dao.vetorTresPaises();
//		return dados;
//	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", nome=" + nome + ", populacao=" + populacao + ", area=" + area + "]";
	}

}