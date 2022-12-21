package test;

import static org.junit.Assert.assertThrows;
import org.junit.Test;

import exception.DescricaoEmBrancoException;
import exception.ValorRendimentoInvalidoException;
import src.Rendimento;

public class TesteExcecaoValorCadastroRendimentos {
	
	@Test
	public void testValorRendimentoInvalido() throws ValorRendimentoInvalidoException, DescricaoEmBrancoException{
		assertThrows(ValorRendimentoInvalidoException.class, () -> new Rendimento("Salário", -10f));
	}
	
}
