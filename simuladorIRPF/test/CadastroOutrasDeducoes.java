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
public class CadastroOutrasDeducoes {
	
	CalculadoraIRPF calculadora;
	Object[][] deducoes;
	float valorEsperado;
	
	public CadastroOutrasDeducoes(Object[][] deducoes, float valorEsperado) {
		this.deducoes = deducoes;
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
				new Object[][] {{"Previdencia privada", 580f}}, 580f				
			},
			{
				new Object[][] {{"Previdencia privada", 200f}, {"Funpresp", 400f}}, 600f
			},
			{
				new Object[][] {{"Previdencia privada", 350f}, {"Funpresp", 400f}, {"Fundo de Saúde", 400f}}, 1150f
			},
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testCadastroDeducoes() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		for(Object[] deducao: deducoes) {
			calculadora.cadastraOutrasDeducoes((String)deducao[0], (float)deducao[1]);
		}
		
		assertEquals(valorEsperado, calculadora.getTotalOutrasDeducoes(), 0f);
	}
	
	
	
	
}