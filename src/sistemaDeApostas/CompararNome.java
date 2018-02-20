package sistemaDeApostas;

import java.util.Comparator;

public class CompararNome implements Comparator <Cenario> {

	private int compare;
	
	@Override
	public int compare(Cenario o1, Cenario o2) {
		compare = o1.getDescricao().compareTo(o2.getDescricao());
		return compare;
	}

}
