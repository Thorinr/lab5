package sistemaDeApostas;

import java.util.ArrayList;

public class ListaDeCenarios {

	private ArrayList <Cenario> cenarios;
	
	public ListaDeCenarios() {
		this.cenarios = new ArrayList <Cenario> ();
	}
	
	public int cadastrarCenario(String descricao) {
		int numeracao = this.cenarios.size() + 1; 
		this.cenarios.add(new Cenario(numeracao, descricao));
		return numeracao;
	}
	
	public String exibirCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		
		return cenarios.get(cenario - 1).toString();
	}
	
	public String exibirCenarios() {
		String retorno = "";
		for (Cenario cenario : this.cenarios ) {
			retorno += cenario.toString() + "\n";
		}
		
		return retorno;
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
		
		this.cenarios.get(cenario - 1).cadastrarAposta(apostador, valor, previsao);
	}
	
	public int valorTotalDeApostas(int cenario) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).getValorTotal();
	}
	
	public int totalDeApostas(int cenario) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
		
		return this.cenarios.get(cenario - 1).getNumeroDeApostas();
	}
	
	public String exibeApostas(int cenario) {
		return this.cenarios.get(cenario - 1).exibeApostas();
	}
	
	public void fecharAposta(int cenario, boolean ocorreu){
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		}
		
		this.cenarios.get(cenario - 1).fecharCenario(ocorreu);
	}
	
	public int getCaixaCenario(int cenario, double taxa) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		}
		
		return this.cenarios.get(cenario - 1).valorCaixa(taxa);
	}
	
	public int getTotalRateioCenario(int cenario) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		}
		
		return this.cenarios.get(cenario - 1).retornaPremio();
	}

}