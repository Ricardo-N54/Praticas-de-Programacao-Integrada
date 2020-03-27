package Aula2;

import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PaisTeste {
	Pais copia; static int id = 0;
	PaisService fixtureS = new PaisService();

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("setup");
		
		Pais menorPais = new Pais(id, "Menor", 10, 1.0);
		Pais maiorPais = new Pais(id, "Maior", 10, 100.0);
		Pais maisPopuloso = new Pais(id, "Mais Populoso", 100, 10.0);

		PaisService menorPaisSS = new PaisService();
		PaisService maiorPaisSS = new PaisService();
		PaisService maisPopulosoSS = new PaisService();

		menorPaisSS.criar(menorPais);
		maiorPaisSS.criar(maiorPais);
		maisPopulosoSS.criar(maisPopuloso);


	}
	
	@AfterEach
	public void reset() throws Exception {
		System.out.println("Truncating table");
		PaisDao menorPais = new PaisDao();
		menorPais.truncate();
		System.out.println();
	}

	@Test
	void testeCriar() {
		Pais fixture = new Pais(4, "Novo Menor", 10, 0.5);

		Pais menorPais = new Pais(1, "Novo Menor", 10, 0.5);
		PaisService menorPaisSS = new PaisService();
		menorPaisSS.criar(menorPais);

		fixture.equals(menorPaisSS.carregar(menorPais.getId()));
	}

	@Test
	void testeCarregar() {
		Pais fixture = new Pais(1, "Menor", 10, 1.0);

		Pais menorPais = new Pais(1, "Menor", 10, 1.0);
		PaisService menorPaisS = new PaisService();
		menorPaisS.criar(menorPais);

		fixture.equals(menorPaisS.carregar(menorPais.getId()));
	}

	@Test
	void testeExcluir() {
		Pais fixture = new Pais(-1, null, 0, 0.0);
		
		Pais menorPais2 = new Pais(1, "Menor", 10, 1.0);
		Pais maiorPais2 = new Pais(2, "Maior", 10, 100.0);
		Pais maisPopuloso2 = new Pais(3, "Mais Populoso", 100, 10.0);
		
		PaisService menorPais2S = new PaisService();
		PaisService maiorPais2S = new PaisService();
		PaisService maisPopuloso2S = new PaisService();

		menorPais2S.excluir1(menorPais2);
		maiorPais2S.excluir1(maiorPais2);
		maisPopuloso2S.excluir1(maisPopuloso2);
		Pais menorPais = new Pais(1, "t", 10, 1.0);
		
		fixture.equals(fixtureS.carregar(menorPais.getId()));
	}

	@Test
	void testeAtualizar() {
		Pais fixture = new Pais(4, "Teste", 9, 1.5);

		Pais novoPais = new Pais(4, "MenorTeste", 10, 1.0);
		PaisService novoPaisS = new PaisService();
		
		Pais novoPaisAtualizado = new Pais(4, "MenorTeste", 10, 1.0);

		novoPaisS.criar(novoPais);
		novoPaisAtualizado.setNome("Teste");
		novoPaisAtualizado.setPopulacao(9);
		novoPaisAtualizado.setArea(1.5);
		novoPaisS.atualizar(novoPaisAtualizado);

		fixture.equals(fixtureS.carregar(novoPaisAtualizado.getId()));
	}

	@Test
	void testeMaiorPopulacao() {
		Pais fixture = new Pais(id, "Mais Populoso", 999999, 15.2);

		Pais pais2 = new Pais(1, "Mais Populoso", 999999, 15.2);

		fixture.equals(fixtureS.carregar(pais2.getId()));
	}

	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testeMenorArea() {
		Pais fixture = new Pais(id, "Menor", 999999, 15.2);

		Pais pais2 = new Pais(id, "Menor", 999999, 15.2);

		fixture.getNome().equals(fixtureS.carregar(pais2.getId()));
	}

	@Test
	void vetorTresPaises() {
		ArrayList<String> fixture = new ArrayList<String>();
		fixture.add("Menor");
		fixture.add("Mais Populoso");
		fixture.add("Maior");

		Pais pais = new Pais(id, "Menor", 999999, 15.2);

		fixture.equals(fixtureS.vetorTresPaises());
	}

}
