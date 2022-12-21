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
import exception.ValorRendimentoInvalidoException;
import src.CalculadoraIRPF;

@RunWith(Parameterized.class)
public class CadastroRendimentos {
	
	CalculadoraIRPF calculadora;
	Object[][] rendimentos;
	float valorEsperado;
	
	public CadastroRendimentos(Object[][] rendimentos, float valorEsperado) {
		this.rendimentos = rendimentos;
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
				new Object[][] {{"Salário", 5000f}}, 5000f				
			},
			{
				new Object[][] {{"Salário", 5000f}, {"Investimentos", 2000f}}, 7000f
			},
			{
				new Object[][] {{"Salário", 5000f}, {"Investimentos", 2000f}, {"Aluguel", 1000f}}, 8000f
			},
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testCadastroRendimentos() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		for(Object[] rendimento: rendimentos) {
			calculadora.cadastraRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		
		assertEquals(valorEsperado, calculadora.getTotalRendimentos(), 0f);
	}
	
	
	
}
