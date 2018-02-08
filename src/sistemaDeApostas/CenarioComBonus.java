package sistemaDeApostas;

public class CenarioComBonus extends Cenario {
	
	private int bonus;
	
	public CenarioComBonus(int numeracao, String descricao, int bonus) {
		super(numeracao, descricao);
		if (bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
		this.bonus = bonus;
	
	}
	
	@Override
	public int retornaPremio() {
		if (super.getEstado().equals("Nao finalizado")) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
		return (int) Math.floor(super.getPremioTotal() + this.bonus);
	}

	@Override
	public String toString() {
		return this.getNumeracao() + " - " + this.getDescricao() + " - " + this.getEstado() + " - R$ " + String.format("%.2f", new Double(this.bonus/100));
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + bonus;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		super.equals(obj);
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CenarioComBonus other = (CenarioComBonus) obj;
		if (bonus != other.bonus)
			return false;
		return true;
	}


	
	
	
	
	
	
	
	
	

}
