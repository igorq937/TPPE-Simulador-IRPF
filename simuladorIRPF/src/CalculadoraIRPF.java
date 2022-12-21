package src;

import java.util.ArrayList;

import exception.DescricaoEmBrancoException;
import exception.ValorRendimentoInvalidoException;

public class CalculadoraIRPF {

	private ArrayList<Rendimento> rendimento;
	private float valorTotalRendimentos;
	
	public CalculadoraIRPF() {
		rendimento = new ArrayList<Rendimento>();
	}
	
	public void cadastraRendimento(String descricao, float valor) throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		rendimento.add(new Rendimento(descricao, valor));
		this.valorTotalRendimentos += valor;
	}

	public float getTotalRendimentos() {
		return valorTotalRendimentos;
	}

}
