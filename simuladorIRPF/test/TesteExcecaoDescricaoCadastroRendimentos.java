package test;

import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exception.DescricaoEmBrancoException;
import exception.ValorDeducaoInvalidoException;
import exception.ValorRendimentoInvalidoException;
import src.ContribuicaoPrevidenciaria;
import src.OutrasDeducoes;
import src.Rendimento;

@RunWith(Parameterized.class)
public class TesteExcecaoDescricaoCadastroRendimentos {
	String descricao;
	
	public TesteExcecaoDescricaoCadastroRendimentos(String descricao) {
		this.descricao = descricao;
	}
	
	@Parameters
	public static List<String> getParameters() {
		String[] parametros = new String[] {
				"   ",
				"",
				null
		};
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testDescricaoEmBranco() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException{
		assertThrows(DescricaoEmBrancoException.class, () -> new Rendimento(descricao, 100f));
	}
	
	@Test
	public void testeExcecaoContribuicaoPrevidenciaria() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException{
		assertThrows(DescricaoEmBrancoException.class, () -> new ContribuicaoPrevidenciaria(descricao, 100f));
	}

	@Test
	public void testeExcecaoOutrasDeducoes() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		assertThrows(DescricaoEmBrancoException.class, () -> new OutrasDeducoes(descricao, 100f));
	}
	
}
