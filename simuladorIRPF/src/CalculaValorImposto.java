package src;

public class CalculaValorImposto {

	private float baseCalculo;
	private float[] faixas = new float[] {0.0f, 0.075f, 0.15f, 0.225f, 0.275f};
	private float[] maxValorFaixa = new float[] {1903.98f, 922.67f, 924.40f, 913.63f, (float)Double.POSITIVE_INFINITY};
	
	public CalculaValorImposto(float baseCalculo) {
		this.baseCalculo = baseCalculo;
	}
	
	public float computa() {
		float totalImposto = 0;
		
		for (int i = 0; i < maxValorFaixa.length; i++) {
			if (baseCalculo <= maxValorFaixa[i]) {
				totalImposto += baseCalculo * faixas[i];
				break;
			}else{
				totalImposto += maxValorFaixa[i] * faixas[i];
			}
			baseCalculo -= maxValorFaixa[i];
		}
	
		return totalImposto;
	}

	
}
