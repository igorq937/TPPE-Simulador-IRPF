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
	
	@Test
	public void testCadastroDoisRendimentos() {
		calculadora.cadastraRendimento("Salario", 5000f);
		calculadora.cadastraRendimento("Investimentos", 2000f);
		assertEquals(7000f, calculadora.getTotalRendimentos(), 0f);
	}
	
	@Test
	public void testCadastroTresRendimentos() {
		calculadora.cadastraRendimento("Salario", 5000f);
		calculadora.cadastraRendimento("Investimentos", 2000f);
		calculadora.cadastraRendimento("Aluguel", 1000f);
		assertEquals(8000f, calculadora.getTotalRendimentos(), 0f);
	}
}
