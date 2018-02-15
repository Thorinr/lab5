package sistemaDeApostas;

public class ApostaAsseguradaTaxa extends Aposta {
	
	private double taxa;
	
	public ApostaAsseguradaTaxa(String nome, int valor, String previsao, double taxa, int id) {
		
		if (nome.equals("") || nome.equals(null) || nome.equals("  ") || nome.equals("   ")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao.equals("") || previsao.equals(null) || previsao.equals("   ") || previsao.equals("  ")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		}
		if(!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Previsao invalida");
		}
		
		setNome(nome);
		setValor(valor);
		setPrevisao(previsao);
		this.taxa = taxa;
		setId(id);
		
	}
	
	@Override
	public int getSeguro() {
		return (int) (this.getValor() * taxa);
	}
	
	
	@Override
	public String toString() {
		return super.toString() + " - ASSEGURADA(TAXA) - " + (this.taxa * 100) + "%";
	}
}
