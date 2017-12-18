package testes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import sistemaDeApostas.Controller;

public class ControllerTest {
	
	private Controller controllerBasico;

	@Before
	public void criarListaDeCenarios() {
		controllerBasico = new Controller();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInicializarCaixaAbaixoDeZero() {
		controllerBasico.inicializa(-1, 0.01);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInicializarTaxaAbaixoDeZero() {
		controllerBasico.inicializa(1000, -0.05);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCenarioVazio() {
		controllerBasico.cadastrarCenario("");
	}
	
	@Test
	public void testGetCaixa() {
		String mensagem = "teste para retornar o valor do caixa";
		controllerBasico.inicializa(1000, 0.01);
		assertEquals(mensagem, 1000, controllerBasico.getCaixa());
	}
	
	
	
	

	
	
}
