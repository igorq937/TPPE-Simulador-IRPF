package src;

import exception.DescricaoEmBrancoException;
import exception.NomeEmBrancoException;
import exception.ValorRendimentoInvalidoException;

public class Dependente {
	
	private String nome;
	private String dataNascimento;
	
	public Dependente (String nome, String dataNascimento) throws NomeEmBrancoException {
		if(nome == null || nome.trim().isEmpty()) {
			throw new NomeEmBrancoException();
		}
		
		this.nome = nome;
		this.dataNascimento= dataNascimento;
	}
	

}
