package sistemaDeApostas;

import java.util.Comparator;

public class CompararApostas implements Comparator<Cenario>{
	
	@Override
	public int compare(Cenario o1, Cenario o2) {
		if(o1.getNumeroDeApostas() < o2.getNumeroDeApostas()) {
			return -1;
		}
		else if(o1.getNumeroDeApostas() == o2.getNumeroDeApostas()) {
			return 0;
		}
		else {
			return 1;
		}
	}

}
