package testes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import sistemaDeApostas.ListaDeCenarios;

public class ListaDeCenariosTest {

	private ListaDeCenarios listaBasica;
	
	@Before
	public void criarListaDeCenarios() {
		listaBasica = new ListaDeCenarios();
	}
	
	public void CadastraCenarios() {
		listaBasica.cadastrarCenario("vou fazer teste1");
		listaBasica.cadastrarCenario("vou fazer teste2");
		listaBasica.cadastrarCenario("vou fazer teste3");
	}
	
	@Test
	public void testCadastrarCenario() {
		String mensagem = "teste para o cadastro de cenario na lista";
		listaBasica.cadastrarCenario("vou fazer teste1");
		listaBasica.cadastrarCenario("vou fazer teste2");
		listaBasica.cadastrarCenario("vou fazer teste3");
		assertEquals(mensagem, "1 - vou fazer teste1 - Nao finalizado", listaBasica.exibirCenario(1));
		assertEquals(mensagem, "2 - vou fazer teste2 - Nao finalizado", listaBasica.exibirCenario(2));
		assertEquals(mensagem, "3 - vou fazer teste3 - Nao finalizado", listaBasica.exibirCenario(3));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioMenorQueZero() {
		listaBasica.exibirCenario(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioIgualAZero() {
		listaBasica.exibirCenario(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioMaiorQueTamanhoDaLista() {
		listaBasica.exibirCenario(5);
	}
	
	@Test
	public void testExibirCenarios() {
		String mensagem = "teste para exibir todos cenarios da lista em lista";
		assertEquals(mensagem, "1 - vou fazer teste1 - Nao finalizado\n2 - vou fazer teste2 - Nao finalizado\n3 - vou fazer teste3 - Nao finalizado", listaBasica.exibirCenarios());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaCenarioMenorQueUm() {
		listaBasica.cadastrarAposta(0, "joão", 5, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaCenarioMaiorQueTamanhoDaLista() {
		listaBasica.cadastrarAposta(5, "joão", 5, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasCenarioMenorQueUm() {
		listaBasica.valorTotalDeApostas(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorTotalDeApostasCenarioMaiorQueTamanhoDaLista() {
		listaBasica.valorTotalDeApostas(5);
	}
	
	@Test
	public void testValorTotalDeApostas() {
		String mensagem = "teste que retorna o valor total das apostas feitas em um cenario";
		listaBasica.cadastrarAposta(1, "joao", 5, "VAI ACONTECER");
		listaBasica.cadastrarAposta(1, "ciro", 10, "VAI ACONTECER");
		listaBasica.cadastrarAposta(1, "nivea", 15, "N VAI ACONTECER");
		listaBasica.cadastrarAposta(1, "ivna", 20, "N VAI ACONTECER");
		assertEquals(mensagem, 50, listaBasica.valorTotalDeApostas(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasCenarioMenorQueUm() {
		listaBasica.totalDeApostas(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTotalDeApostasCenarioMaiorQueTamanhoDaLista() {
		listaBasica.totalDeApostas(5);
	}
	
	@Test
	public void testTotalDeApostas() {
		String mensagem = "teste que retorna o numero De apostas feitas para um cenario";
		assertEquals(mensagem, 4, listaBasica.totalDeApostas(1));
	}
	
	@Test
	public void testExibeApostas() {
		String mensagem = "teste imprime a representação das apostas feitas para um cenario";
		assertEquals(mensagem, " - joao - 5 - VAI ACONTECER\n - ciro - 10 - VAI ACONTECER\n - nivea - 15 - N VAI ACONTECER\n - ivna - 20 - N VAI ACONTECER", listaBasica.exibeApostas(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFecharApostaCenarioMenorQueUm() {
		listaBasica.fecharAposta(0, true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFecharApostaCenarioMaiorQueTamanhoDaLista() {
		listaBasica.fecharAposta(0, true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioMenorQueUm() {
		listaBasica.getCaixaCenario(0, 0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioMaiorQueTamanhoDaLista() {
		listaBasica.getCaixaCenario(5, 0.01);
	}
	
	@Test
	public void testGetCaixaCenario() {
		String mensagem = "teste que retorna o valor a ser adicionado ao caixa do sistema";
		assertEquals(mensagem, 5, listaBasica.getCaixaCenario(1, 0.1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioMenorQueUm() {
		listaBasica.getTotalRateioCenario(0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioMaiorQueTamanhoDaLista() {
		listaBasica.getTotalRateioCenario(5);
	}
	
	@Test
	public void testGetTotalRateioCenario() {
		String mensagem = "teste que retorna o valor a ser distribuidos aos vencedores do cenario";
		listaBasica.fecharAposta(1, false);
		assertEquals(mensagem, 15, listaBasica.getTotalRateioCenario(1));
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
