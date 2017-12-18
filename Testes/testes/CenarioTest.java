package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistemaDeApostas.Cenario;

public class CenarioTest {

	private Cenario cenarioBasico;
	
	@Before
	public void criarCenario() {
		cenarioBasico = new Cenario(1, "teste");
	}
	
	@Test
	public void testToString() {
		String mensagem = "Teste do toString";
		assertEquals(mensagem, "1 - teste - Nao finalizado", cenarioBasico.toString());
		
	}
	
	@Test
	public void testExibeApostas() {
		String mensagem = "test para o cadastro de Apostas para o cenario";
		cenarioBasico.cadastrarAposta("ciro", 10, "VAI ACONTECER");
		cenarioBasico.cadastrarAposta("nivea", 20, "N VAI ACONTECER");
		assertEquals(mensagem," - ciro - 10 - VAI ACONTECER\n - nivea - 20 - N VAI ACONTECER\n",cenarioBasico.exibeApostas());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValorCaixaNaoFinalizado() {
		cenarioBasico.retornaPremio();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRetornaPremioNaoFinalizado() {
		cenarioBasico.valorCaixa(0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFecharCenarioJaFechado() {
		cenarioBasico.fecharCenario(true);
		cenarioBasico.fecharCenario(false);
	}
	
	@Test
	public void testValorCaixa() {
		String mensagem = "teste que retorna o valor que vai ser adicionado ao caixa do sistema";
		assertEquals(mensagem, 2,cenarioBasico.valorCaixa(0.1));
	}
	
	@Test
	public void testRetornaPremio() {
		String mensagem ="test que retorna o valor do premio dos vencedores";
		assertEquals(mensagem, 18,cenarioBasico.retornaPremio());
	}

	
	
	
	
	

}
