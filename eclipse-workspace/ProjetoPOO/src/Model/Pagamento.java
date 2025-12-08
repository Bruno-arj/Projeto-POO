package Model;

import java.time.LocalDateTime;

public class Pagamento {
	protected int id;
	protected int idReserva;
	protected double valorPago;
	protected LocalDateTime dataPagamento;
	protected String metodo;
	
	public Pagamento(int id, int idReserva, double valorPago, LocalDateTime dataPagamento, String metodo) {
		this.id = id;
		this.idReserva = idReserva;
		this.valorPago = valorPago;
		this.dataPagamento = dataPagamento;
		this.metodo = metodo;
	}

	public int getId() {
		return id;
	}

	public int getIdReserva() {
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
