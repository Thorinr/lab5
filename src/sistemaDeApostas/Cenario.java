package sistemaDeApostas;

import java.util.HashSet;

public class Cenario {
	
	private int numeracao;
	private String descricao;
	private String estado;
	private HashSet <Aposta> conjuntoDeApostas;
	private int valorTotal;
	private double premioTotal;
	private int custoSeguro;
	private int id;
	
	public Cenario (int numeracao, String descricao) {
		if (descricao.equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		
		this.numeracao = numeracao;
		this.descricao = descricao;
		this.conjuntoDeApostas = new HashSet <Aposta> ();
		this.estado = "Nao finalizado";
		this.valorTotal = 0;
		this.custoSeguro = 0;
		this.id = 0;
	}
	
	@Override
	public String toString() {
		return this.descricao + " - " + this.estado;
	}

	public String getEstado() {
		return estado;
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
	
	public int cadastrarApostaSeguraValor(String apostador, int valor, String previsao, int seguro) {
		this.valorTotal += valor;
		this.id += 1;
		this.conjuntoDeApostas.add(new ApostaAsseguradaValor(apostador, valor, previsao, seguro, id));
		return id;
	}
	
	public int cadastrarApostaSeguraTaxa(String apostador, int valor, String previsao, double taxa) {
		this.valorTotal += valor;
		this.id += 1;
		this.conjuntoDeApostas.add(new ApostaAsseguradaTaxa(apostador, valor, previsao, taxa, id));
		return id;
	}
	
	public int alterarSeguroValor(int apostaAssegurada, int valor) {
		this.id += 1;
		Aposta apostaModificada = getApostaAssegurada(apostaAssegurada);
		this.conjuntoDeApostas.add(new ApostaAsseguradaValor(apostaModificada.getNome(), apostaModificada.getValor(), apostaModificada.getPrevisao(), valor, id));
		this.conjuntoDeApostas.remove(apostaModificada);
		return id;
	}
	
	public int alterarSeguroTaxa(int apostaAssegurada, double taxa) {
		this.id += 1;
		Aposta apostaModificada = getApostaAssegurada(apostaAssegurada);
		this.conjuntoDeApostas.add(new ApostaAsseguradaTaxa(apostaModificada.getNome(), apostaModificada.getValor(), apostaModificada.getPrevisao(), taxa, id));
		this.conjuntoDeApostas.remove(apostaModificada);
		return id;
	}
	
	public Aposta getApostaAssegurada(int id) {
		for (Aposta aposta : conjuntoDeApostas) {
			if(aposta.getId() == id) {
				return aposta;
			}
		}
		return null;
	}
	
	public int getValorTotal() {
		return valorTotal;
	}
	
	public int getNumeroDeApostas() {
		return conjuntoDeApostas.size();
	}
	

	public double getPremioTotal() {
		return this.premioTotal;
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
				if(aposta.getId() != 0) {
					this.custoSeguro += aposta.getSeguro();
				}
			}
		}
		
		double valorCaixa = Math.floor(dinheiroArrecadado * taxa) ;
		this.premioTotal = (dinheiroArrecadado - valorCaixa) ;
		return (int) valorCaixa;
	}
	
	public int retornaPremio() {
		if (this.estado.equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		
		return (int) Math.floor(this.premioTotal);
	}
	
	public int getCustoSeguro(){
		
		return custoSeguro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conjuntoDeApostas == null) ? 0 : conjuntoDeApostas.hashCode());
		result = prime * result + numeracao;
		return result;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (conjuntoDeApostas == null) {
			if (other.conjuntoDeApostas != null)
				return false;
		} else if (!conjuntoDeApostas.equals(other.conjuntoDeApostas))
			return false;
		if (numeracao != other.numeracao)
			return false;
		return true;
	}
	
	
}