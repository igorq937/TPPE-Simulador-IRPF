package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exception.DescricaoEmBrancoException;
import exception.ValorDeducaoInvalidoException;
import src.CalculadoraIRPF;

@RunWith(Parameterized.class)
public class CadastroContribuicaoPrevidenciaria {
	
	CalculadoraIRPF calculadora;
	Object[][] contribuicoes;
	float valorEsperado;
	
	public CadastroContribuicaoPrevidenciaria(Object[][] contribuicoes, float valorEsperado) {
		this.contribuicoes = contribuicoes;
		this.valorEsperado = valorEsperado;
	}
	
	@Before
	public void setup() {
		calculadora = new CalculadoraIRPF(); 
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {
		// {[Descricao, Valor], valorEsperado]}		
		Object[][] parametros = new Object[][] {
			{
				new Object[][] {{"Contribuicao Previdenciaria", 5000f}}, 5000f				
			},
			{
				new Object[][] {{"Contribuicao Previdenciaria", 5000f}, {"Contribuicao Previdenciaria MEI", 2000f}}, 7000f
			},
			{
				new Object[][] {{"Contribuicao Previdenciaria", 5000f}, {"Contribuicao Previdenciaria MEI", 2000f}, {"Contribuicao Previdenciaria Obrigatoria", 1000f}}, 8000f
			},
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testCadastroContribuicoes() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		for(Object[] contribuicao: contribuicoes) {
			calculadora.cadastraContribuicaoPrevidenciaria((String)contribuicao[0], (float)contribuicao[1]);
		}
		
		assertEquals(valorEsperado, calculadora.getTotalContribuicaoPrevidenciaria(), 0f);
	}
	
	
	
	
}