package Aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Aula5.Pais;
import Aula5.PaisService;


@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNome = request.getParameter("nome");
		String p = (request.getParameter("populacao"));
		int pPopulacao = (p == "")? 0 : Integer.parseInt(p);
		String a = request.getParameter("area");
		double pArea = (a == "")? 0 : Double.parseDouble(a);
		String acao = request.getParameter("acao");
		
		
		Pais pais = new Pais();
		pais.setNome(pNome);
		pais.setPopulacao(pPopulacao);
		pais.setArea(pArea);
		
		PaisService ps = new PaisService();
		RequestDispatcher dispatcher = null;

		
		switch(acao){
		case "Incluir":
			ps.criar(pais);
			pais = ps.carregar(pais.getId());
			
			
			request.setAttribute("pais", pais);
			dispatcher = request.getRequestDispatcher("Pais.jsp");
			break;
		case "Listar":
			ArrayList<Pais> paises = ps.listarTodos();
			request.setAttribute("paises", paises);
			dispatcher = request.getRequestDispatcher("ListaDePaises.jsp");
		}
		
		
		
		dispatcher.forward(request, response);		
	}

}
