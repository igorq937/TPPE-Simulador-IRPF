package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exception.NomeEmBrancoException;
import src.CalculadoraIRPF;

@RunWith(Parameterized.class)
public class CadastroDependente {
	
	CalculadoraIRPF calculadora;
	Object[][] dependentes;
	int totalDependentes;
	
	public CadastroDependente(Object[][] dependentes, int totalDependentes) {
		this.dependentes = dependentes;
		this.totalDependentes = totalDependentes;
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
				new Object[][] {{"Alberto","21/10/2001"}}, 1				
			},
			{
				new Object[][] {{"Juliano","04/05/1994"}, {"Alfred","27/04/1985"}}, 2
			},
			{
				new Object[][] {{"Silverio","10/08/1984"}, {"Golçanves","12/09/2000"}, {"Pereira","14/05/1991"}}, 3
			},
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testQuantidadeDependentes() throws NomeEmBrancoException {
		for(Object[] dependente: dependentes) {
			calculadora.cadastraDependente((String)dependente[0],(String)dependente[1]);
		}
		
		assertEquals(totalDependentes, calculadora.getQuantidadeDependentes(), 0);
	}
	
	@Test
	public void testValorTotalDependentes() throws NomeEmBrancoException {
		for(Object[] dependente: dependentes) {
			calculadora.cadastraDependente((String)dependente[0],(String)dependente[1]);
		}
		
		assertEquals(totalDependentes*189.59, calculadora.getTotalDependentes(), 0.0001f);
	}
	
}