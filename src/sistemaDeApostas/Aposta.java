package sistemaDeApostas;

public class Aposta {

	private String nome;
	private int valor;
	private String previsao;
	private int id;
	
	public Aposta() {
		
	}

	public Aposta(String nome, int valor, String previsao) {
		if (nome.equals("") || nome.equals(null) || nome.equals("  ")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
		if (valor <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		if (previsao.equals("") || previsao.equals(null) || previsao.equals("   ")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		if(!previsao.equals("VAI ACONTECER") && !previsao.equals("N VAI ACONTECER")) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
		
		this.nome = nome;
		this.valor = valor;
		this.previsao = previsao;
		this.id = 0;
	}
	
	public String getPrevisao() {
		return this.previsao;
	}
	
	public int getValor() {
		return this.valor;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public int getId() {
		return id;
	}
	
	public double seguro() {
		return 0;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getSeguro() {
		return 0;
	}
	
	@Override
	public String toString() {
		return this.nome + " - " + this.valor + " - " + this.previsao; 
	}
	
	
	
}