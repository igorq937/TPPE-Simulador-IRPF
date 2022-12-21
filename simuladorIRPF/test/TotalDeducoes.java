package test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

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
import src.CalculadoraIRPF;

@RunWith(Parameterized.class)
public class TotalDeducoes {
	
	CalculadoraIRPF calculadora;
	Object[][] dependentes;
	Object[][] outrasDeducoes;
	Object[][] previdencias;
	float[] pensoes;
	float valorEsperado;


	public TotalDeducoes(Object[][] dependentes, Object[][] outras, Object[][] previdencia,
			float[] pensoes, float valorEsperado) {
		super();
		this.previdencias = previdencia;
		this.dependentes = dependentes;
		this.outrasDeducoes = outras;
		this.pensoes = pensoes;
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
				new Object[][] {{"Jonh","14/01/2005"}} ,
				new Object[][] {{"Uma boa descricao", 1000f}},
				new Object[][] {{"Outra belissima descricao",1050f}} ,
			 	new float[]	{1000f}, 
			 	3239.59f				
			},
			{
				new Object[][] {{"Jonny","14/01/2005"},{"Amber","15/07/2004"}} ,
				new Object[][] {{"Uma boa descricao", 1000f},{"Nao eh piramide, confia", 2000f}},
				new Object[][] {{"Outra belissima descricao",1050f},{"Escreva aqui uma descricao",1150f}} ,
			 	new float[]	{1000f,2000f}, 
			 	8579.18f				
			},
			{
				new Object[][] {},
				new Object[][] {{"Uma boa descricao", 1000f},{"Nao eh piramide, confia", 2000f},{"Descreve", 1000f}},
				new Object[][] {{"Outra belissima descricao",1050f},{"Escreva aqui uma descricao",1150f},{"Descreve outras deducoes",500f}} ,
			 	new float[]	{1000f,2000f,1500f}, 
			 	11200f				
			},
		};
		
		return Arrays.asList(parametros);
	}
	
	@Test
	public void testTotalDeducoes() throws DescricaoEmBrancoException, ValorDeducaoInvalidoException, NomeEmBrancoException {
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
		assertEquals(calculadora.getTotalDeducoes(), valorEsperado,0.001f);
	}
	
}
