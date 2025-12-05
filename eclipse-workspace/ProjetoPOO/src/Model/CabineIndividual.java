package Model;

public class CabineIndividual extends Espaco {

	public CabineIndividual(int id, String nome, int capacidade, boolean disponivel) {
		super(id, nome, capacidade, disponivel, 50.0);
	}
	
	public CabineIndividual() {
		super();
	}

	public double calcularCustoReserva(long horas) {
		double valor = horas * this.precoPorHora;
		if (horas > 4) {
			valor = valor - (valor * 0.10);
			return valor;
		}
		return valor;
	}
	
}
