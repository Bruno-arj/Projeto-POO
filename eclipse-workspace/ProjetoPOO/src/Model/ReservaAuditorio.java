	package Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class ReservaAuditorio {
	protected int id;
	protected Auditorio auditorio;
	protected LocalDateTime inicio;
	protected LocalDateTime fim;
	protected double valorCalculado;
	protected boolean cancelada;
	
	public ReservaAuditorio(int id, Auditorio auditorio, LocalDateTime inicio, LocalDateTime fim, double valorCalculado,
			boolean cancelada) {
		this.id = id;
		this.auditorio = auditorio;
		this.inicio = inicio;
		this.fim = fim;
		this.valorCalculado = valorCalculado;
		this.cancelada = cancelada;
	}
	
	

	public int getId() {
		return id;
	}
	
	public Auditorio getEspaco() {
		return auditorio;
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
		return auditorio.calcularCustoReserva(getDuracaoEmHoras());
	}
	
	public void setCancelada(boolean cancelada) {
		this.cancelada = cancelada;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", espaco=" + auditorio + ", inicio=" + inicio + ", fim=" + fim + ", valorCalculado="
				+ valorCalculado + ", cancelada=" + cancelada + ", taxaCancelamento=" + "]";
	}
	
	
}
