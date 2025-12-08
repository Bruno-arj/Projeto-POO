	package Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class ReservaSalaDeReuniao {
	protected int id;
	protected SalaDeReuniao salaDeReuniao;
	protected LocalDateTime inicio;
	protected LocalDateTime fim;
	protected double valorCalculado;
	protected boolean cancelada;
	
	public ReservaSalaDeReuniao(int id, SalaDeReuniao salaDeReuniao, LocalDateTime inicio, LocalDateTime fim, double valorCalculado,
			boolean cancelada) {
		this.id = id;
		this.salaDeReuniao = salaDeReuniao;
		this.inicio = inicio;
		this.fim = fim;
		this.valorCalculado = valorCalculado;
		this.cancelada = cancelada;
	}
	
	

	public int getId() {
		return id;
	}
	
	public SalaDeReuniao getEspaco() {
		return salaDeReuniao;
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
		return salaDeReuniao.calcularCustoReserva(getDuracaoEmHoras());
	}
	
	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", espaco=" + salaDeReuniao + ", inicio=" + inicio + ", fim=" + fim + ", valorCalculado="
				+ valorCalculado + ", cancelada=" + cancelada + ", taxaCancelamento=" + "]";
	}
	
	
}
