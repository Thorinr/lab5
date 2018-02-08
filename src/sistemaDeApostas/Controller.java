package sistemaDeApostas;

public class Controller {
	
	private int caixa;
	private double taxa;
	private ListaDeCenarios listaDeCenarios;
	
	public Controller() {
		this.listaDeCenarios = new ListaDeCenarios();
	}
	
	public void inicializa(int caixa, double taxa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
		if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
		
		this.caixa = caixa;
		this.taxa = taxa;
	}
	
	public int getCaixa() {
		return this.caixa;
	}

	public int cadastrarCenario(String descricao) {
		return listaDeCenarios.cadastrarCenario(descricao);
	}
	
	public int cadastrarCenario(String descricao, int bonus) {
		if(bonus > caixa) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: bônus é maior que o caixa");
		}
		this.caixa -= bonus;
		return listaDeCenarios.cadastrarCenario(descricao, bonus);
	}

	public String exibirCenario(int cenario) {
		return listaDeCenarios.exibirCenario(cenario);
	}

	public String exibirCenarios() {
		return listaDeCenarios.exibirCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		listaDeCenarios.cadastrarAposta(cenario, apostador, valor, previsao);
	}
	
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int seguro, int custo) {
		this.caixa += custo;
		return listaDeCenarios.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao,seguro);
	}
	
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo) {
		this.caixa += custo;
		return listaDeCenarios.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao,taxa);
	}
	
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return listaDeCenarios.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}
	
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return listaDeCenarios.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return listaDeCenarios.valorTotalDeApostas(cenario);
	}
	
	public int totalDeApostas(int cenario) {
		return listaDeCenarios.totalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return listaDeCenarios.exibeApostas(cenario);
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		listaDeCenarios.fecharAposta(cenario, ocorreu);
	}
	
	public int getCaixaCenario(int cenario) {
		int retorno = listaDeCenarios.getCaixaCenario(cenario, this.taxa);
		this.caixa += retorno;
		return retorno;
	}
	
	public int getTotalRateioCenario(int cenario) {
		return listaDeCenarios.getTotalRateioCenario(cenario);
	}
	
}