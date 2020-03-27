package Aula2;

import java.util.ArrayList;

public class PaisService{
	PaisDao dao;

	public PaisService() {
		dao = new PaisDao();
	}

	public void criar(Pais to) {
		dao.criar(to);
	}

	public void atualizar(Pais to) {
		dao.atualizar(to);
	}

	public void excluir1(Pais to) {
		dao.excluir(to);
	}

	public Pais carregar(int id) {
		Pais to = dao.carregar(id);
		return to;
	}

	public void truncate() {
		PaisDao dao = new PaisDao();
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

	public Object vetorTresPaises() {
		
		return null;
	}

	
	}

	
