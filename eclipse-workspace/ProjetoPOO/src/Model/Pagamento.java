package Model;

import java.time.LocalDateTime;

public class Pagamento {
	protected String id;
	protected String idReserva;
	protected double valorPago;
	protected LocalDateTime dataPagamento;
	protected String metodo;
	
	public Pagamento(String id, String idReserva, double valorPago, LocalDateTime dataPagamento, String metodo) {
		super();
		this.id = id;
		this.idReserva = idReserva;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
		this.metodo = metodo;
	}

	public String getId() {
		return id;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public double getValorPago() {
		return valorPago;
	}

	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}

	public String getMetodo() {
		return metodo;
	}
	
	
	
	
}
