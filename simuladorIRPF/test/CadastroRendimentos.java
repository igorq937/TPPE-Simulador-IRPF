package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import src.CalculadoraIRPF;


public class CadastroRendimentos {
	
	CalculadoraIRPF calculadora;
	
	
	@Before
	public void setup() {
		calculadora = new CalculadoraIRPF(); 
	}
	
	@Test
	public void testCadastroRendimento() {
		calculadora.cadastraRendimento("Salario", 5000f);
		assertEquals(5000f, calculadora.getTotalRendimentos(), 0f);
	}
}
