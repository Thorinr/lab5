package sistemaDeApostas;

public class ApostaAsseguradaTaxa extends Aposta {
	
	private double taxa;
	private int id;
	
	public ApostaAsseguradaTaxa(String nome, int valor, String previsao, double taxa, int id) {
		super(nome, valor, previsao);
		this.taxa = taxa;
		this.id = id;
		
	}
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - ASSEGURADA(TAXA) - " + (this.taxa * 100) + "%";
	}
}
