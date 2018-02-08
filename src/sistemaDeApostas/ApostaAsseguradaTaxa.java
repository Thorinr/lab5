package sistemaDeApostas;

public class ApostaAsseguradaTaxa extends Aposta {
	
	private double taxa;
	
	public ApostaAsseguradaTaxa(String nome, int valor, String previsao, double taxa, int id) {
		super(nome, valor, previsao);
		this.taxa = taxa;
		this.id = id;
		
	}
	
	@Override
	public double seguro() {
		return this.getValor() * taxa;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " - ASSEGURADA(TAXA) - " + (this.taxa * 100) + "%";
	}
}
