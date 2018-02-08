package sistemaDeApostas;

import easyaccept.EasyAccept;

public class Facade {
	
	private Controller controle;
	
	public Facade(){
		controle = new Controller();
	}
	
	public void inicializa(int caixa, double taxa) {
		controle.inicializa(caixa, taxa);
	}
	
	public int getCaixa() {
		return controle.getCaixa();
	}

	public int cadastrarCenario(String descricao) {
		return controle.cadastrarCenario(descricao);
	}
	
	public int cadastrarCenario(String descricao, int bonus){
		return controle.cadastrarCenario(descricao, bonus);
	}

	public String exibirCenario(int cenario) {
		return controle.exibirCenario(cenario);
	}

	public String exibirCenarios() {
		return controle.exibirCenarios();
	}
	
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		controle.cadastrarAposta(cenario, apostador, valor, previsao);;
	}
	
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor,String previsao, int seguro,int custo) {
		return controle.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, seguro, custo);
	}
	
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa, int custo) {
		return controle.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);	
	}
	
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return controle.alterarSeguroValor(cenario, apostaAssegurada, valor);
	}
	
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return controle.alterarSeguroTaxa(cenario, apostaAssegurada, taxa);
	}
	
	public int valorTotalDeApostas(int cenario) {
		return controle.valorTotalDeApostas(cenario);
	}
	
	
	public int totalDeApostas(int cenario) {
		return controle.totalDeApostas(cenario);
	}
	
	public String exibeApostas(int cenario) {
		return controle.exibeApostas(cenario);
	}
	
	public void fecharAposta(int cenario, boolean ocorreu) {
		controle.fecharAposta(cenario, ocorreu);;
	}
	
	public int getCaixaCenario(int cenario) {
		return controle.getCaixaCenario(cenario);
	}
	
	public int getTotalRateioCenario(int cenario) {
		return controle.getTotalRateioCenario(cenario);
	}
	
	public static void main(String[] args) {
		args = new String[] {"sistemaDeApostas.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt", "acceptance_test/us3_test.txt" , "acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt", "acceptance_test/us6_test.txt"};
		EasyAccept.main(args);
	}
	
	
}