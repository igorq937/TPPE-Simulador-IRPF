package src;

import exception.DescricaoEmBrancoException;
import exception.ValorDeducaoInvalidoException;

public class ContribuicaoPrevidenciaria {
	
	private String descricao;
	private float valor;
	
	public ContribuicaoPrevidenciaria (String descricao, float valor) throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		if(descricao == null || descricao.trim().isEmpty()) {
			throw new DescricaoEmBrancoException();
		}
		if(valor <= 0f) {
			throw new ValorDeducaoInvalidoException();
		}
		this.descricao = descricao;
		this.valor = valor;
	}

}
