package Aula1;

import java.util.ArrayList;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class PaisTeste {
	Pais copia; static int id = 0;

	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("setup");
		Pais menorPais = new Pais(id, "Menor", 10, 1.0);
		Pais maiorPais = new Pais(id, "Maior", 10, 100.0);
		Pais maisPopuloso = new Pais(id, "Mais Populoso", 100, 10.0);

		menorPais.criar();
		maiorPais.criar();
		maisPopuloso.criar();


	}
	
	@AfterEach
	public void reset() throws Exception {
		System.out.println("Truncating table");
		Pais menorPais = new Pais(id, "Menor", 10, 1.0);
		menorPais.truncate();
		System.out.println();
	}

	@Test
	void testeCriar() {
		Pais fixture = new Pais(4, "Novo Menor", 10, 0.5);

		Pais menorPais = new Pais(1, "Novo Menor", 10, 0.5);
		menorPais.criar();

		fixture.equals(menorPais);
	}

	@Test
	void testeCarregar() {
		Pais fixture = new Pais(1, "Menor", 10, 1.0);

		Pais menorPais = new Pais(1, "Menor", 10, 1.0);

		fixture.equals(menorPais.carregar());
	}

	@Test
	void testeExcluir() {
		Pais fixture = new Pais(-1, null, 0, 0.0);
		
		Pais menorPais2 = new Pais(1, "Menor", 10, 1.0);
		Pais maiorPais2 = new Pais(2, "Maior", 10, 100.0);
		Pais maisPopuloso2 = new Pais(3, "Mais Populoso", 100, 10.0);

		menorPais2.excluir();
		maiorPais2.excluir();
		maisPopuloso2.excluir();
		Pais menorPais = new Pais(1, "a", 10, 1.0);
		
		fixture.equals(menorPais.carregar());
	}

	@Test
	void testeAtualizar() {
		Pais fixture = new Pais(4, "Teste", 9, 1.5);

		Pais novoPais = new Pais(4, "MenorTeste", 10, 1.0);
		Pais novoPaisAtualizado = new Pais(4, "MenorTeste", 10, 1.0);

		novoPais.criar();
		novoPaisAtualizado.setNome("Teste");
		novoPaisAtualizado.setPopulacao(9);
		novoPaisAtualizado.setArea(1.5);
		novoPais.atualizar(novoPaisAtualizado);

		fixture.equals(novoPaisAtualizado.carregar());
	}

	@Test
	void testeMaiorPopulacao() {
		Pais fixture = new Pais(id, "Mais Populoso", 999999, 15.2);

		Pais pais2 = new Pais(1, "Mais Populoso", 999999, 15.2);

		fixture.getNome().equals(pais2.MaiorPopulacao());
	}

	@Test
	void testeMenorArea() {
		Pais fixture = new Pais(id, "Menor", 999999, 15.2);

		Pais pais2 = new Pais(id, "Menor", 999999, 15.2);

		fixture.getNome().equals(pais2.MenorArea());
	}

	@Test
	void vetorTresPaises() {
		ArrayList<String> fixture = new ArrayList<String>();
		fixture.add("Menor");
		fixture.add("Mais Populoso");
		fixture.add("Maior");

		Pais pais2 = new Pais(id, "Menor", 999999, 15.2);

		fixture.equals(pais2.vetorTresPaises());
	}

}