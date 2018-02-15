package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sistemaDeApostas.ApostaAsseguradaValor;

public class ApostaAsseguradaValorTest {
	
	private ApostaAsseguradaValor apostaBasica;
	
	@Before
	public void criarAposta() {
		apostaBasica = new ApostaAsseguradaValor("ciro", 1000, "VAI ACONTECER", 100, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComNomeVazio() {
		apostaBasica = new ApostaAsseguradaValor ("", 5, "VAI ACONTECER", 100, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComValorIgualAZero() {
		apostaBasica = new ApostaAsseguradaValor ("joao", 0, "VAI ACONTECER", 100, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComValorMenorQueZero() {
		apostaBasica = new ApostaAsseguradaValor ("joao", -5, "VAI ACONTECER", 100, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComPrevisaoDiferenteDasOpções() {
		apostaBasica = new ApostaAsseguradaValor ("joao", 10, "Sei Lá", 100, 1);
	}
	
	
	@Test
	public void testGetSeguro() {
		
		String mensagem = "teste que retorna o seguro da aposta";
		assertEquals(mensagem, 100, apostaBasica.getSeguro());
	}
	
	@Test
	public void testToString() {
		
		String mensagem = "teste do toString";
		assertEquals(mensagem, "ciro - 1000 - VAI ACONTECER - ASSEGURADA(VALOR) - R$100", apostaBasica.toString());
	}
}
