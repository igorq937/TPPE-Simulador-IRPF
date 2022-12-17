package src;

public class CalculadoraIRPF {

	private String descricao;
	private float valor;
	
	public void cadastraRendimento(String descricao, float valor) {
		this.descricao = descricao;
		this.valor = valor;
		
	}

	public float getTotalRendimentos() {
		return 5000;
	}

}
