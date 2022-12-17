package src;

import java.util.ArrayList;

public class CalculadoraIRPF {

	private ArrayList<Rendimento> rendimento;
	private float valorTotalRendimentos;
	
	public CalculadoraIRPF() {
		rendimento = new ArrayList<Rendimento>();
	}
	
	public void cadastraRendimento(String descricao, float valor) {
		rendimento.add(new Rendimento(descricao, valor));
		this.valorTotalRendimentos += valor;
	}

	public float getTotalRendimentos() {
		return valorTotalRendimentos;
	}

}
