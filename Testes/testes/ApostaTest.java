package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import sistemaDeApostas.Aposta;

public class ApostaTest {

	private Aposta apostaBasica;
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComNomeVazio() {
		apostaBasica = new Aposta ("", 5, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComNomeNulo() {
		apostaBasica = new Aposta (null, 5, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComValorIgualAZero() {
		apostaBasica = new Aposta ("joao", 0, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComValorMenorQueZero() {
		apostaBasica = new Aposta ("joao", -5, "VAI ACONTECER");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCriarApostaComPrevisaoDiferenteDasOpções() {
		apostaBasica = new Aposta ("joao", 10, "Sei Lá");
	}
	
	@Test
	public void testToString() {
		String mensagem = "teste da representação da aposta";
		apostaBasica = new Aposta("joao", 10, "VAI ACONTECER");
		assertEquals(mensagem, "joao - 10 - VAI ACONTECER", apostaBasica.toString());
	}
	
	

}
