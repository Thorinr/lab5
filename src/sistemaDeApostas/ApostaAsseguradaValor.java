package sistemaDeApostas;

public class ApostaAsseguradaValor extends Aposta{
	
	
	private int seguro;
	
	public ApostaAsseguradaValor (String nome, int valor, String previsao, int seguro, int id) {
		
		if (nome.equals("") || nome.equals(null) || nome.equals("  ") || nome.equals("   ")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao.equals("") || previsao.equals(null) || previsao.equals("   ") || previsao.equals("  ")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		}
		if(!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Previsao invalida");
		}
		
		setNome(nome);
		setValor(valor);
		setPrevisao(previsao);
		this.seguro = seguro;
		setId(id);
		
	}
	@Override
	public int getSeguro() {
		return seguro;
	}
	
	@Override
	public String toString() {
		return super.toString() + " - ASSEGURADA(VALOR) - R$" + this.seguro;
	}
	

}
