package Service;
import Model.Auditorio;
import java.util.ArrayList;
import Model.Reserva;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservaAuditorioService {
	ArrayList<Reserva> listaAuditorio = new ArrayList<Reserva>();
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public String ReservaAuditorio(int id, String nome, int capacidade, boolean disponivel,
										  String dataInicio, String dataFim) {
		LocalDateTime inicio = ConverterData(dataInicio);
		LocalDateTime fim = ConverterData(dataFim);
		if (fim.isBefore(inicio)) {
			return "Erro throws quando der certo coloca pra retorna o preco";
		}
		else if(inicio.equals(fim)) {
			return "Erro throws quando der certo coloca pra retorna preco";
		}
		Auditorio auditorio = new Auditorio(id,nome,capacidade,disponivel);
		Duration duracao = Duration.between(inicio, fim);
		long horas = duracao.toHours();
		double custo = auditorio.calcularCustoReserva(horas);
		
		Reserva reserva = new Reserva(id, auditorio, inicio, fim, custo,false);
		
		AdicionarListaAuditorio(reserva);
		return "Reserva bem sucedida";
	}
	
	public LocalDateTime ConverterData(String data) {
		return LocalDateTime.parse(data, formato);
	}

	private void AdicionarListaAuditorio(Reserva reserva) {
		listaAuditorio.add(reserva);
	}

	public ArrayList<Reserva> getListaAuditorio() {
		return listaAuditorio;
	}

	@Override
	public String toString() {
		return "ReservaAuditorioService [listaAuditorio=" + listaAuditorio + "]";
	}
	
	
}
