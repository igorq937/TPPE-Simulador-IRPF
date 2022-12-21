package src;

import exception.DescricaoEmBrancoException;
import exception.ValorRendimentoInvalidoException;

public class Rendimento {

	private String descricao;
	private float valor;
	
	public Rendimento(String descricao, float valor) throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		if(descricao == null || descricao.trim().isEmpty()) {
			throw new DescricaoEmBrancoException();
		}
		if(valor <= 0f) {
			throw new ValorRendimentoInvalidoException();
		}
		this.descricao = descricao;
		this.valor = valor;
	}
}
