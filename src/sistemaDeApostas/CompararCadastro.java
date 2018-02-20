package sistemaDeApostas;

import java.util.Comparator;

public class CompararCadastro implements Comparator<Cenario> {
	
	@Override
	public int compare(Cenario o1, Cenario o2) {
		if(o1.getNumeracao() < o2.getNumeracao()) {
			return -1;
		}
		else if(o1.getNumeracao() == o2.getNumeracao()) {
			return 0;
		}
		else {
			return 1;
		}
	}

}
