package Model;

import java.time.LocalDateTime;

public class Pagamento {
	protected int id;
	protected String idReserva;
	protected double valorPago;
	protected LocalDateTime dataPagamento;
	protected String metodo;
	
	public Pagamento(int id, String idReserva, double valorPago, LocalDateTime dataPagamento, String metodo) {
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
