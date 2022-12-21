package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exception.ValorDeducaoInvalidoException;
import src.CalculadoraIRPF;

@RunWith(Parameterized.class)
public class CadastroPensaoAlimenticia {
	
	CalculadoraIRPF calculadora;
	Object[][] pensaoAlimenticias;
	float valorEsperado;
	
	public CadastroPensaoAlimenticia(Object[][] pensaoAlimenticias, float valorEsperado) {
		this.pensaoAlimenticias = pensaoAlimenticias;
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
				new Object[][] {{5000f}}, 5000f				
			},
			{
				new Object[][] {{5000f}, {2000f}}, 7000f
			},
			{
				new Object[][] {{5000f}, {2000f}, {1000f}}, 8000f
			},
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testCadastroPensoes() throws ValorDeducaoInvalidoException {
		for(Object[] pensaoAlimenticia: pensaoAlimenticias) {
			calculadora.cadastraPensaoAlimenticia((float)pensaoAlimenticia[0]);
		}
		
		assertEquals(valorEsperado, calculadora.getTotalPensaoAlimenticia(), 0f);
	}
	
	
	
	
}