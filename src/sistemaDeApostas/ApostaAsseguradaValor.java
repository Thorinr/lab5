package sistemaDeApostas;

public class ApostaAsseguradaValor extends Aposta{
	
	private int seguro;
	
	public ApostaAsseguradaValor (String nome, int valor, String previsao, int seguro, int id) {
		super(nome, valor, previsao);
		this.seguro = seguro;
		this.id = id;
		
	}
	
	@Override
	public double seguro() {
		return seguro;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - ASSEGURADA(VALOR) - R$" + this.seguro;
	}
	

}
