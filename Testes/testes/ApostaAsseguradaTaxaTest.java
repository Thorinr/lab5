package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistemaDeApostas.ApostaAsseguradaTaxa;

public class ApostaAsseguradaTaxaTest {
	
	private ApostaAsseguradaTaxa apostaBasica;
	
	@Before
	public void criarAposta() {
		apostaBasica = new ApostaAsseguradaTaxa("ciro", 1000, "VAI ACONTECER", 0.1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComNomeVazio() {
		apostaBasica = new ApostaAsseguradaTaxa ("", 5, "VAI ACONTECER", 0.1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComValorIgualAZero() {
		apostaBasica = new ApostaAsseguradaTaxa ("joao", 0, "VAI ACONTECER", 0.1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComValorMenorQueZero() {
		apostaBasica = new ApostaAsseguradaTaxa ("joao", -5, "VAI ACONTECER", 0.1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComPrevisaoDiferenteDasOpções() {
		apostaBasica = new ApostaAsseguradaTaxa ("joao", 10, "Sei Lá", 0.1, 1);
	}
	
	@Test
	public void testGetSeguro() {
		
		String mensagem = "teste que retorna o seguro da aposta";
		assertEquals(mensagem, 100, apostaBasica.getSeguro());
	}
	
	@Test
	public void testToString() {
		
		String mensagem = "teste do toString";
		assertEquals(mensagem, "ciro - 1000 - VAI ACONTECER - ASSEGURADA(TAXA) - 10.0%", apostaBasica.toString());
	}
}
