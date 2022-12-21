package test;

import static org.junit.Assert.assertThrows;

import org.junit.Test;

import exception.DescricaoEmBrancoException;
import exception.ValorDeducaoInvalidoException;
import src.ContribuicaoPrevidenciaria;
import src.OutrasDeducoes;
import src.PensaoAlimenticia;

public class TesteExcecaoValorDeducaoInvalido extends Exception {
	
	@Test
	public void testeExcecaoContribuicaoPrevidenciaria() throws ValorDeducaoInvalidoException, DescricaoEmBrancoException {
		assertThrows(ValorDeducaoInvalidoException.class, () -> new ContribuicaoPrevidenciaria("Previdencia obrigatoria", 0));
	}
	
	@Test
	public void testeExcecaoContribuicaoPrevidenciaria1() throws ValorDeducaoInvalidoException {
		assertThrows(ValorDeducaoInvalidoException.class, () -> new PensaoAlimenticia(0));
	}
	
	@Test
	public void testeExcecaoValorDeducaoInvalidoException() throws ValorDeducaoInvalidoException, DescricaoEmBrancoException {
		assertThrows(ValorDeducaoInvalidoException.class, () -> new OutrasDeducoes("Investimentos", 0));
	}
	
}
