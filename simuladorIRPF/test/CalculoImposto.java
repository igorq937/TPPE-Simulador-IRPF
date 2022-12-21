package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.DescricaoEmBrancoException;
import exception.NomeEmBrancoException;
import exception.ValorDeducaoInvalidoException;
import exception.ValorRendimentoInvalidoException;
import src.CalculadoraIRPF;

public class CalculoImposto {
	
	@Test
	public void testeCalculoBase() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException, ValorDeducaoInvalidoException {
		CalculadoraIRPF calculadora = new CalculadoraIRPF();
		calculadora.cadastraRendimento("Investimento", 2000f);
		calculadora.cadastraOutrasDeducoes("Previdencia Privada", 200f);
		assertEquals(calculadora.getBaseCalculo(), 1800f, 0.01f);
		assertEquals(calculadora.getValorImposto(), 0.0f, 0f);
	}
	
	@Test
	public void testeCalculoImposto2() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException, ValorDeducaoInvalidoException, NomeEmBrancoException {
		CalculadoraIRPF calculadora = new CalculadoraIRPF();
		calculadora.cadastraRendimento("Investimento", 2000f);
		calculadora.cadastraRendimento("Salario", 3000f);
		calculadora.cadastraOutrasDeducoes("Previdencia Privada", 200f);
		calculadora.cadastraDependente("Jao", "09/10/2000");
		assertEquals(calculadora.getBaseCalculo(), 4610.41f, 0.01f);
		assertEquals(calculadora.getValorImposto(), 401.21f, 0.01f);
	}
	
	@Test
	public void testeCalculoImposto3() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException, ValorDeducaoInvalidoException, NomeEmBrancoException {
		CalculadoraIRPF calculadora = new CalculadoraIRPF();
		calculadora.cadastraRendimento("Investimento", 2000f);
		calculadora.cadastraRendimento("Salario", 3000f);
		calculadora.cadastraPensaoAlimenticia(500f);
		calculadora.cadastraOutrasDeducoes("Previdencia Privada", 200f);
		calculadora.cadastraDependente("Jao", "09/10/2000");
		assertEquals(calculadora.getBaseCalculo(), 4110.41, 0.001f);
		assertEquals(calculadora.getValorImposto(), 288.71f, 0.01f);
	}
	
}