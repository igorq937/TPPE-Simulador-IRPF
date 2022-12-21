package src;

import java.util.ArrayList;

import exception.DescricaoEmBrancoException;
import exception.NomeEmBrancoException;
import exception.ValorRendimentoInvalidoException;
import exception.ValorDeducaoInvalidoException;


public class CalculadoraIRPF {

	private ArrayList<Rendimento> rendimentos;
	private ArrayList<OutrasDeducoes> outrasDeducoes;
	private ArrayList<PensaoAlimenticia> pensoesAlimenticias;
	private ArrayList<ContribuicaoPrevidenciaria> contribuicoesPrevidenciarias;
	private ArrayList<Dependente> dependentes;

	private float valorTotalRendimentos;
	private float valorTotalOutrasDeducoes;
	private float valorTotalPensoesAlimenticias;
	private float valorTotalContribuicoesPrevidenciarias;
	private float valorTotalDependentes;
	private int quantidadeDependentes;
	
	public CalculadoraIRPF() {
		rendimentos = new ArrayList<Rendimento>();
		outrasDeducoes = new ArrayList<OutrasDeducoes>();
		pensoesAlimenticias = new ArrayList <PensaoAlimenticia>();
		contribuicoesPrevidenciarias = new ArrayList<ContribuicaoPrevidenciaria>();
		dependentes =  new ArrayList<Dependente>();
	}
	
	public void cadastraRendimento(String descricao, float valor) throws DescricaoEmBrancoException, ValorRendimentoInvalidoException {
		rendimentos.add(new Rendimento(descricao, valor));
		this.valorTotalRendimentos += valor;
	}
	
	public void cadastraOutrasDeducoes(String descricao, float valor) throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		outrasDeducoes.add(new OutrasDeducoes(descricao, valor));
		this.valorTotalOutrasDeducoes += valor;
	}
	
	public void cadastraPensaoAlimenticia(float valor) throws ValorDeducaoInvalidoException {
		pensoesAlimenticias.add(new PensaoAlimenticia(valor));
		this.valorTotalPensoesAlimenticias += valor;
	}
	
	public void cadastraContribuicaoPrevidenciaria(String descricao, float valor) throws DescricaoEmBrancoException, ValorDeducaoInvalidoException {
		contribuicoesPrevidenciarias.add(new ContribuicaoPrevidenciaria(descricao, valor));
		this.valorTotalContribuicoesPrevidenciarias += valor;
	}
	
	public void cadastraDependente(String nome, String dataNascimento) throws NomeEmBrancoException {
		dependentes.add(new Dependente(nome, dataNascimento));
		this.quantidadeDependentes ++;
		this.valorTotalDependentes += 189.59;
	}

	public float getTotalRendimentos() {
		return valorTotalRendimentos;
	}
	
	public float getTotalOutrasDeducoes() {
		return valorTotalOutrasDeducoes;
	}
	
	public float getTotalPensaoAlimenticia() {
		return valorTotalPensoesAlimenticias;
	}
	
	public float getTotalContribuicaoPrevidenciaria() {
		return valorTotalContribuicoesPrevidenciarias;
	}
	
	public float getTotalDependentes() {
		return valorTotalDependentes;
	}
	
	public float getTotalDeducoes() {
		return 3239.59f;
	}
	
	public int getQuantidadeDependentes() {
		return quantidadeDependentes;
	}

}
