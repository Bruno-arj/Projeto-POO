package Model;

import java.time.Duration;
import java.time.LocalDateTime;

public class Reserva {
	protected String id;
	protected Espaco espaco;
	protected LocalDateTime inicio;
	protected LocalDateTime fim;
	protected double valorCalculado;
	protected boolean cancelada;
	
	protected double taxaCancelamento;
	protected LocalDateTime dataCancelamento;
	
	
	public Reserva(String id, Espaco espaco, LocalDateTime inicio, LocalDateTime fim, double valorCalculado,
			boolean cancelada, double taxaCancelamento, LocalDateTime dataCancelamento) {
		super();
		this.id = id;
		this.espaco = espaco;
		this.inicio = inicio;
		this.fim = fim;
		this.valorCalculado = valorCalculado;
		this.cancelada = cancelada;
		this.taxaCancelamento = taxaCancelamento;
		this.dataCancelamento = dataCancelamento;
	}
	
	

	public String getId() {
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

	public double getTaxaCancelamento() {
		return taxaCancelamento;
	}

	
	public LocalDateTime getDataCancelamento() {
		return dataCancelamento;
	}
	
	public long getDuracaoEmHoras() {
		return Duration.between(inicio, fim).toHours();
	}
	
	public double calcularValor() {
		return espaco.calcularCustoReserva(getDuracaoEmHoras());
	}
	
	
}
