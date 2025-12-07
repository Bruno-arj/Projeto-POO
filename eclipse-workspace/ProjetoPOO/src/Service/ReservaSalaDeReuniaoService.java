package Service;
import java.util.ArrayList;
import Model.SalaDeReuniao;
import Model.Reserva;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReservaSalaDeReuniaoService {
	ArrayList<Reserva> listaSalaDeReuniao = new ArrayList<Reserva>();
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public String ReservaSalaDeReuniao(int id, String nome, int capacidade, boolean disponivel, boolean projetor ,
										  String dataInicio, String dataFim) {
		LocalDateTime inicio = ConverterData(dataInicio);
		LocalDateTime fim = ConverterData(dataFim);
		if (fim.isBefore(inicio)) {
			return "Erro throws quando der certo coloca pra retorna o preco";
		}
		else if(inicio.equals(fim)) {
			return "Erro throws quando der certo coloca pra retorna preco";
		}
		else if(VerificarDatas(inicio, fim) == "Erro conflito") {
			return "Erro conflito";
		}
		SalaDeReuniao salaDeReuniao = new SalaDeReuniao(id,nome,capacidade,disponivel,projetor);
		Duration duracao = Duration.between(inicio, fim);
		long horas = duracao.toHours();
		double custo = salaDeReuniao.calcularCustoReserva(horas);
		
		Reserva reserva = new Reserva(id, salaDeReuniao, inicio, fim, custo,false);
		
		AdicionarListaSalaDeReuniao(reserva);
		return "Reserva bem sucedida";
	}
	
	private LocalDateTime ConverterData(String data) {
		return LocalDateTime.parse(data, formato);
	}
	
	private String VerificarDatas(LocalDateTime inicio, LocalDateTime fim) {
		for (int i = 0; i < listaSalaDeReuniao.size() ; i++ ) {
			if (inicio.isBefore(listaSalaDeReuniao.get(i).getFim())) {
				return "Erro conflito";
			}
			else if (fim.isBefore(listaSalaDeReuniao.get(i).getFim())) {
				return "Erro conflito";
			}		
		}
		return "Tudo certo";
	}
	
	private void AdicionarListaSalaDeReuniao(Reserva salaDeReuniao) {
		listaSalaDeReuniao.add(salaDeReuniao);
	}
	
	public ArrayList<Reserva> getListaSalaDeReuniao() {
		return listaSalaDeReuniao;
	}

	@Override
	public String toString() {
		return "ReservaSalaDeReuniaoService [listaSalaDeReuniao=" + listaSalaDeReuniao + "]";
	}	
}
