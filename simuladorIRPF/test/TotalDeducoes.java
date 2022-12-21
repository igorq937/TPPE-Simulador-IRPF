package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import exception.DescricaoEmBrancoException;
import exception.NomeEmBrancoException;
import exception.ValorDeducaoInvalidoException;
import src.CalculadoraIRPF;

public class TotalDeducoes {
	
	@Test
	public void testTotalDeducoes() throws NomeEmBrancoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException{
		CalculadoraIRPF calculadora = new CalculadoraIRPF();
		
		calculadora.cadastraContribuicaoPrevidenciaria("Uma boa descricao", 1000f);
		calculadora.cadastraDependente("Jonh","14/01/2005");
		calculadora.cadastraOutrasDeducoes("Outra belissima descricao",1050f);
		calculadora.cadastraPensaoAlimenticia(1000f);
		
		assertEquals(calculadora.getTotalDeducoes(), 3239.59f,0.001);
	}

}
