	package Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class ReservaCabineIndividual {
	protected int id;
	protected CabineIndividual cabineIndividual;
	protected LocalDateTime inicio;
	protected LocalDateTime fim;
	protected double valorCalculado;
	protected boolean cancelada;
	
	public ReservaCabineIndividual(int id, CabineIndividual cabineIndividual, LocalDateTime inicio, LocalDateTime fim, double valorCalculado,
			boolean cancelada) {
		this.id = id;
		this.cabineIndividual = cabineIndividual;
		this.inicio = inicio;
		this.fim = fim;
		this.valorCalculado = valorCalculado;
		this.cancelada = cancelada;
	}
	
	

	public int getId() {
		return id;
	}
	
	public CabineIndividual getEspaco() {
		return cabineIndividual;
	}
	
	public LocalDateTime getInicio() {
		return inicio;
	}
	
	public LocalDateTime getFim() {
		return fim;
	}
	
	public double getValorCalculado() {
		return valorCalculado;
	}

	public boolean isCancelada() {
		return cancelada;
	}

	public long getDuracaoEmHoras() {
		return Duration.between(inicio, fim).toHours();
	}
	
	public double calcularValor() {
		return cabineIndividual.calcularCustoReserva(getDuracaoEmHoras());
	}
	
	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", espaco=" + cabineIndividual + ", inicio=" + inicio + ", fim=" + fim + ", valorCalculado="
				+ valorCalculado + ", cancelada=" + cancelada + ", taxaCancelamento=" + "]";
	}
	
	
}
