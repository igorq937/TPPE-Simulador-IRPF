package test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import exception.DescricaoEmBrancoException;
import exception.NomeEmBrancoException;
import exception.ValorDeducaoInvalidoException;
import exception.ValorRendimentoInvalidoException;
import src.CalculadoraIRPF;

@RunWith(Parameterized.class)
public class CalculoImposto {
	
	CalculadoraIRPF calculadora;
	Object[][] rendimentos;
	Object[][] dependentes;
	Object[][] outrasDeducoes;
	Object[][] previdencias;
	float[] pensoes;
	float valorEsperadoBaseCalculo;
	float valorEsperadoImposto;
	
	public CalculoImposto(Object[][] rendimentos, Object[][] dependentes, Object[][] outrasDeducoes,
			Object[][] previdencias, float[] pensoes, float valorEsperadoBaseCalculo, float valorEsperadoImposto) {
		super();
		this.rendimentos = rendimentos;
		this.dependentes = dependentes;
		this.outrasDeducoes = outrasDeducoes;
		this.previdencias = previdencias;
		this.pensoes = pensoes;
		this.valorEsperadoBaseCalculo = valorEsperadoBaseCalculo;
		this.valorEsperadoImposto = valorEsperadoImposto;
	}
	
	@Before
	public void setup() {
		calculadora = new CalculadoraIRPF(); 
	}
	
	@Parameters
	public static Collection<Object[]> getParameters() {	
		Object[][] parametros = new Object[][] {
			{
				new Object[][] {{"Investimento", 2000f}},
				new Object[][] {},
				new Object[][] {{"Previdencia Privada", 200f}},
				new Object[][] {},
			 	new float[]	{}, 
			 	1800f,
			 	0.0f
			},
			{
				new Object[][] {{"Investimento", 2000f}, {"Salario", 3000f}},
				new Object[][] {{"Jao", "09/10/2000"}},
				new Object[][] {{"Previdencia Privada", 200f}},
				new Object[][] {},
			 	new float[]	{}, 
			 	4610.41f,
			 	401.21f
			},
			{
				new Object[][] {{"Investimento", 2000f}, {"Salario", 3000f}},
				new Object[][] {{"Jao", "09/10/2000"}},
				new Object[][] {{"Previdencia Privada", 200f}},
				new Object[][] {{"Previdencia Obrigatpria", 110f}},
			 	new float[]	{500f}, 
			 	4000.41f,
			 	263.96f
			},
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testeCalculoImposto() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException, NomeEmBrancoException, ValorRendimentoInvalidoException {
		for(Object[] rendimento : rendimentos) {
			calculadora.cadastraRendimento((String)rendimento[0], (float)rendimento[1]);
		}
		for(Object[] dependente: dependentes) {
			calculadora.cadastraDependente((String)dependente[0], (String)dependente[1]);
		}
		for(float pensao: pensoes) {
			calculadora.cadastraPensaoAlimenticia(pensao);
		}
		for(Object[] previdencia: previdencias) {
			calculadora.cadastraContribuicaoPrevidenciaria((String)previdencia[0], (float)previdencia[1]);
		}
		for(Object[] outraDeducao: outrasDeducoes) {
			calculadora.cadastraOutrasDeducoes((String)outraDeducao[0], (float)outraDeducao[1]);
		}
		
		assertEquals(calculadora.getBaseCalculo(), valorEsperadoBaseCalculo, 0.01f);
		assertEquals(calculadora.getValorImposto(), valorEsperadoImposto, 0.01f);
	}
	
}