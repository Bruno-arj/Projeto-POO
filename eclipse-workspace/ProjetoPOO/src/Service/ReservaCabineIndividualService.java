package Service;
import Model.CabineIndividual;

import Model.Reserva;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ReservaCabineIndividualService {
	ArrayList<Reserva> listaIndividual = new ArrayList<Reserva>();
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public String ReservaCabine(int id, String nome, int capacidade, boolean disponivel, 
										  String dataInicio, String dataFim) {
		LocalDateTime inicio = ConverterData(dataInicio);
		LocalDateTime fim = ConverterData(dataFim);
		if (fim.isBefore(inicio)) {
			return "Erro throws quando der certo coloca pra retorna o preco";
		}
		else if(inicio.equals(fim)) {
			return "Erro throws quando der certo coloca pra retorna preco";
		}
		CabineIndividual cabineIndividual = new CabineIndividual(id,nome,capacidade,disponivel);
		Duration duracao = Duration.between(inicio, fim);
		long horas = duracao.toHours();
		double custo = cabineIndividual.calcularCustoReserva(horas);
		
		Reserva reserva = new Reserva(id, cabineIndividual, inicio, fim, custo,false);
		
		AdicionarListaCabine(reserva);
		return "Reserva bem sucedida";
	}
	
	public LocalDateTime ConverterData(String data) {
		return LocalDateTime.parse(data, formato);
	}
	
	private void AdicionarListaCabine(Reserva reservaCabineIndividual) {
		listaIndividual.add(reservaCabineIndividual);
	}

	public ArrayList<Reserva> getListaIndividual() {
		return listaIndividual;
	}

	@Override
	public String toString() {
		return "ReservaCabineIndividualService [listaIndividual=" + listaIndividual + "]";
	}
	
}
