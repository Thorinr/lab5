package sistemaDeApostas;

import java.util.HashSet;

public class Cenario {
	
	private int numeracao;
	private String descricao;
	private String estado;
	private HashSet <Aposta> conjuntoDeApostas;
	private int valorTotal;
	private double premiototal;
	
	public Cenario (int numeracao, String descricao) {
		if (descricao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		
		this.numeracao = numeracao;
		this.descricao = descricao;
		this.conjuntoDeApostas = new HashSet <Aposta> ();
		this.estado = "Nao finalizado";
		this.valorTotal = 0;
	}
	
	@Override
	public String toString() {
		return this.numeracao + " - " + this.descricao + " - " + this.estado;
	}

	public int getNumeracao() {
		return numeracao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public void cadastrarAposta(String apostador, int valor, String previsao) {
		this.valorTotal += valor;
		this.conjuntoDeApostas.add(new Aposta(apostador, valor, previsao));
	}
	
	public int getValorTotal() {
		return valorTotal;
	}
	
	public int getNumeroDeApostas() {
		return conjuntoDeApostas.size();
	}
	
	public String exibeApostas() {
		String retorno = "";
		for (Aposta aposta : conjuntoDeApostas) {
			retorno +=" - " + aposta.toString() + "\n";
		}
		return retorno;
	}
	
	public void fecharCenario(boolean ocorreu) {
		if (!this.estado.equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
		if(ocorreu) {
			this.estado = "Finalizado (ocorreu)";
		}
		else {
			this.estado = "Finalizado (n ocorreu)";
		}
	}
	
	public int valorCaixa(double taxa) {
		if (this.estado.equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		double dinheiroArrecadado = 0;
		String ganhador = "";
		
		if(this.estado.equals("Finalizado (ocorreu)")) {
			ganhador = "VAI ACONTECER";	
		}
		
		else {
			ganhador = "N VAI ACONTECER";
		}
		
		for (Aposta aposta : conjuntoDeApostas) {
			if (!aposta.getPrevisao().equals(ganhador)) {
				dinheiroArrecadado += aposta.getValor();
			}
		}
		
		double valorCaixa = (dinheiroArrecadado * taxa) ;
		this.premiototal = (dinheiroArrecadado - valorCaixa) ;
		return (int) Math.floor(valorCaixa);
	}
	
	public int retornaPremio() {
		if (this.estado.equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		
		return (int) Math.floor(this.premiototal);
	}
	
	
}