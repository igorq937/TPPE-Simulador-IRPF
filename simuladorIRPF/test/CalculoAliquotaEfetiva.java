package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import exception.DescricaoEmBrancoException;
import exception.ValorRendimentoInvalidoException;
import src.CalculadoraIRPF;

public class CalculoAliquotaEfetiva {
	
	@Test
	public void testeCalculoAliquotaEfetiva() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		CalculadoraIRPF calculadora = new CalculadoraIRPF();
		calculadora.cadastraRendimento("Salario", 2000f);
		assertEquals(calculadora.getAliquotaEfetiva(), 7.20f, 0.01f);
	}
	
}
