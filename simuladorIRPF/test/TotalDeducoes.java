package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import exception.DescricaoEmBrancoException;
import exception.NomeEmBrancoException;
import exception.ValorDeducaoInvalidoException;
import src.CalculadoraIRPF;

public class TotalDeducoes {
	
	@Test
	public void testTotalDeducoes() throws NomeEmBrancoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException{
		CalculadoraIRPF calculadora = new CalculadoraIRPF();
		
		calculadora.cadastraContribuicaoPrevidenciaria("Uma boa descricao", 1000f);
		calculadora.cadastraDependente("Jonh","14/01/2005");
		calculadora.cadastraOutrasDeducoes("Outra belissima descricao",1050f);
		calculadora.cadastraPensaoAlimenticia(1000f);
		
		assertEquals(calculadora.getTotalDeducoes(), 3239.59f,0.001);
	}
	
	@Test
	public void testTotalDeducoes2() throws NomeEmBrancoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException{
		CalculadoraIRPF calculadora = new CalculadoraIRPF();
		
		calculadora.cadastraContribuicaoPrevidenciaria("Uma boa descricao", 1000f);
		calculadora.cadastraContribuicaoPrevidenciaria("Nao eh piramide, confia", 2000f);
		calculadora.cadastraDependente("Jonny","14/01/2005");
		calculadora.cadastraDependente("Amber","15/07/2004");
		calculadora.cadastraOutrasDeducoes("Outra belissima descricao",1050f);
		calculadora.cadastraOutrasDeducoes("Escreva aqui uma descricao",1150f);
		calculadora.cadastraPensaoAlimenticia(1000f);
		calculadora.cadastraPensaoAlimenticia(2000f);
		
		assertEquals(calculadora.getTotalDeducoes(), 8579.18f,0.001);
	}

	@Test
	public void testTotalDeducoes3() throws NomeEmBrancoException, DescricaoEmBrancoException, ValorDeducaoInvalidoException{
		CalculadoraIRPF calculadora = new CalculadoraIRPF();
		
		calculadora.cadastraContribuicaoPrevidenciaria("Uma boa descricao", 1000f);
		calculadora.cadastraContribuicaoPrevidenciaria("Nao eh piramide, confia", 2000f);
		calculadora.cadastraContribuicaoPrevidenciaria("Descreve", 1000f);
		calculadora.cadastraOutrasDeducoes("Outra belissima descricao",1050f);
		calculadora.cadastraOutrasDeducoes("Escreva aqui uma descricao",1150f);
		calculadora.cadastraOutrasDeducoes("Descreve outras deducoes",500f);
		calculadora.cadastraPensaoAlimenticia(1000f);
		calculadora.cadastraPensaoAlimenticia(2000f);
		calculadora.cadastraPensaoAlimenticia(1500f);
		
		assertEquals(calculadora.getTotalDeducoes(), 11200f,0.001);
	}
}
