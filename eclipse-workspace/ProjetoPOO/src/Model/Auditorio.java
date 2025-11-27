package Model;

public class Auditorio extends Espaco {

	public Auditorio(String id, String nome, int capacidade, boolean disponivel) {
		super(id, nome, capacidade, disponivel, 120.0);
	}

	public double calcularCustoReserva(long horas) {
		double valor = horas * this.precoPorHora;
		return valor + 100.0;
	}
	
}
