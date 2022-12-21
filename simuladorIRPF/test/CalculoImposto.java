package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import exception.DescricaoEmBrancoException;
import exception.ValorDeducaoInvalidoException;
import exception.ValorRendimentoInvalidoException;
import src.CalculadoraIRPF;

public class CalculoImposto {
	
	@Test
	public void testeCalculoBase() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException, ValorDeducaoInvalidoException {
		CalculadoraIRPF calculadora = new CalculadoraIRPF();
		calculadora.cadastraRendimento("Investimento", 2000f);
		calculadora.cadastraOutrasDeducoes("Previdencia Privada", 200f);
		assertEquals(calculadora.getBaseCalculo(), 1800f, 0.001f);
		assertEquals(calculadora.getValorImposto(), 0.0f, 0f);
	}
	
}