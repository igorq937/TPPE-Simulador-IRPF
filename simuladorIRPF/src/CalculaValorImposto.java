package src;

public class CalculaValorImposto {
	private float baseCalculo;
	private final float[] FAIXAS = new float[] {0.0f, 0.075f, 0.15f, 0.225f, 0.275f};
	private final float[] MAX_VALOR_FAIXAS = new float[] {1903.98f, 922.67f, 924.40f, 913.63f, (float)Double.POSITIVE_INFINITY};
	
	public CalculaValorImposto(float baseCalculo) {
		this.baseCalculo = baseCalculo;
	}
	
	public float computa() {
		float totalImposto = 0;
		
		for (int i = 0; i < MAX_VALOR_FAIXAS.length; i++) {
			if (baseCalculo <= MAX_VALOR_FAIXAS[i]) {
				totalImposto += baseCalculo * FAIXAS[i];
				break;
			}else{
				totalImposto += MAX_VALOR_FAIXAS[i] * FAIXAS[i];
			}
			baseCalculo -= MAX_VALOR_FAIXAS[i];
		}
	
		return totalImposto;
	}

	
}
