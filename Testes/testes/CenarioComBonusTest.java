package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistemaDeApostas.CenarioComBonus;

public class CenarioComBonusTest {
	
	private CenarioComBonus cenarioBasico;
	
	@Before
	public void criarCenario() {
		cenarioBasico = new CenarioComBonus(1, "teste", 1000);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBonusInvalido() {
		cenarioBasico = new CenarioComBonus(1, "teste", -100);
	}
	
	@Test
	public void testToString() {
		
		String mensagem = "Teste do toString";
		assertEquals(mensagem, "1 - teste - Nao finalizado - R$ 10,00", cenarioBasico.toString());
	}
	
	@Test
	public void testRetornaPremio() {
		cenarioBasico.cadastrarAposta("ciro", 10, "VAI ACONTECER");
		cenarioBasico.cadastrarAposta("nivea", 20, "N VAI ACONTECER");
		cenarioBasico.fecharCenario(true);
		cenarioBasico.valorCaixa(0.1);
		String mensagem = "teste que retorna o valor do premio dos vencedores";
		assertEquals(mensagem, 1018, cenarioBasico.retornaPremio());
	}
	
	
}
