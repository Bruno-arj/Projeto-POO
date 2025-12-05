package Model;

public class SalaDeReuniao extends Espaco{
	
	protected boolean projetor;
		
	
	public SalaDeReuniao(int id, String nome, int capacidade, boolean disponivel, boolean projetor) {
		super(id, nome, capacidade, disponivel, 80.0);
		this.projetor = projetor;
	}

	
	public boolean isProjetor() {
		return projetor;
	}

	
	public double calcularCustoReserva(long horas) {
		double valor = horas * precoPorHora;
		if (this.projetor) {
			valor += 15;
		} else {
			return valor;
		}
		return valor;
	}
	

	
}
