package src;

import exception.ValorDeducaoInvalidoException;

public class PensaoAlimenticia {
	
	private float valor;
	
	public PensaoAlimenticia (float valor) throws ValorDeducaoInvalidoException {
		if(valor <= 0f) {
			throw new ValorDeducaoInvalidoException();
		}
		
		this.valor = valor;
	}

}
