package aula4;

import java.util.ArrayList;

public class PaisService{
	PaisDAO dao;

	public PaisService() {
		dao = new PaisDAO();
	}

	public void criar(Pais to) {
		dao.criar(to);
	}

	public void atualizar(Pais to) {
		dao.atualizar(to);
	}

	public void excluir(Pais to) {
		dao.excluir(to);
	}

	public Pais carregar(int id) {
		Pais to = dao.carregar(id);
		return to;
	}

	public void truncate() {
		PaisDAO dao = new PaisDAO();
		dao.truncate();
	}

	public Pais maiorPopulacao() {
		Pais to = dao.maiorPopulacao();
		return to;
	}

	public Pais menorArea() {
		Pais to = dao.menorArea();
		return to;
	}

	public ArrayList<String> vetorTresPaises() {
		ArrayList<String> to = dao.vetorTresPaises();
		return to;
	}

	public ArrayList<Pais> listarTodos() {
		ArrayList<Pais> to = dao.listarTodos();
		return to;
	}
	
}
