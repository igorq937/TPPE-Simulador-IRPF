package test;

import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exception.NomeEmBrancoException;
import exception.ValorRendimentoInvalidoException;
import src.Dependente;

@RunWith(Parameterized.class)
public class TesteExcecaoNomeEmBrancoCadastroDependente {
	
	String descricao;
	
	public TesteExcecaoNomeEmBrancoCadastroDependente(String descricao) {
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
	public void testeExcecaoDependente() throws NomeEmBrancoException, ValorRendimentoInvalidoException {
		assertThrows(NomeEmBrancoException.class, () -> new Dependente(descricao, "24/07/1994"));
	}
	
}
