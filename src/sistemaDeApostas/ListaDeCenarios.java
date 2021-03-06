package sistemaDeApostas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	
	public int cadastrarCenario(String descricao, int bonus) {
		int numeracao = this.cenarios.size() + 1; 
		this.cenarios.add(new CenarioComBonus(numeracao, descricao, bonus));
		return numeracao;
	}
	
	public String exibirCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		
		return cenario + " - " + cenarios.get(cenario - 1).toString();
	}
	
	public String exibirCenarios() {
		String retorno = "";
		int contador = 0;
		for (Cenario cenario : this.cenarios ) {
			contador += 1;
			retorno += contador + " - " + cenario.toString() + "\n";
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
	
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int seguro) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		}
		return this.cenarios.get(cenario - 1).cadastrarApostaSeguraValor(apostador, valor, previsao, seguro);
	}
	
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa) {
		if (cenario < 1) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		}
		if (cenario > this.cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		}
		
		return this.cenarios.get(cenario - 1).cadastrarApostaSeguraTaxa(apostador, valor, previsao, taxa);
	}
	
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return this.cenarios.get(cenario - 1).alterarSeguroValor(apostaAssegurada, valor);
	}
	
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double  taxa) {
		return this.cenarios.get(cenario - 1).alterarSeguroTaxa(apostaAssegurada, taxa);
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
	
	public int getCustoSeguro(int cenario) {
		
		return this.cenarios.get(cenario -1).getCustoSeguro();
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
	public void alterarOrdem(String ordem) {
		if (ordem.equals("Nome")) {
			CompararNome comparaNome = new CompararNome();
			Collections.sort(cenarios, comparaNome);
		}
		else if(ordem.equals("Apostas")) {
			CompararApostas comparaApostas = new CompararApostas();
			Collections.sort(cenarios, comparaApostas);
		}
		else if(ordem.equals("Cadastro")){
			CompararCadastro comparaCadastro = new CompararCadastro();
			Collections.sort(cenarios, comparaCadastro);;
		}
	}
	
	public String exibirCenarioOrdenado(int cenario) {
		return cenario + " - " + this.cenarios.get(cenario - 1).toString();
	}

}