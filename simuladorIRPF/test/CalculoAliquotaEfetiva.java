package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exception.DescricaoEmBrancoException;
import exception.ValorRendimentoInvalidoException;
import src.CalculadoraIRPF;

@RunWith(Parameterized.class)
public class CalculoAliquotaEfetiva {
	
	CalculadoraIRPF calculadora;
	Object[] rendimentos;
	float valorEsperado;
	
	
	public CalculoAliquotaEfetiva(Object[] rendimentos, float valorEsperado) {
		super();
		this.rendimentos = rendimentos;
		this.valorEsperado = valorEsperado;
	}


	@Before
	public void setup() {
		calculadora = new CalculadoraIRPF();
	}
	
	@Parameters
	public static List<Object> getParameters() {	
		Object[] parametros = new Object[][] {
			{
				new Object[] {"Salario", 2000f}, 0.0036f			
			},
			{
				new Object[] {"Salario", 1000f}, 0.0f			
			},
			{
				new Object[] {"Salario", 1903.98f}, 0.0f		
			},
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testeCalculoAliquotaEfetiva() throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		calculadora.cadastraRendimento((String)rendimentos[0], (float)rendimentos[1]);
		assertEquals(calculadora.getAliquotaEfetiva(), valorEsperado, 0.01f);
	}
	
}
