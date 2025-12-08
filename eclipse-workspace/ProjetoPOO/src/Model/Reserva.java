	package Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Reserva {
	protected int id;
	protected Espaco espaco;
	protected LocalDateTime inicio;
	protected LocalDateTime fim;
	protected double valorCalculado;
	protected boolean cancelada;
	
	public Reserva(int id, Espaco espaco, LocalDateTime inicio, LocalDateTime fim, double valorCalculado,
			boolean cancelada) {
		this.id = id;
		this.espaco = espaco;
		this.inicio = inicio;
		this.fim = fim;
		this.valorCalculado = valorCalculado;
		this.cancelada = cancelada;
	}
	
	

	public int getId() {
		return id;
	}
	
	public Espaco getEspaco() {
		return espaco;
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
		return espaco.calcularCustoReserva(getDuracaoEmHoras());
	}
	
	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", espaco=" + espaco + ", inicio=" + inicio + ", fim=" + fim + ", valorCalculado="
				+ valorCalculado + ", cancelada=" + cancelada + ", taxaCancelamento=" + "]";
	}
	
	
}
