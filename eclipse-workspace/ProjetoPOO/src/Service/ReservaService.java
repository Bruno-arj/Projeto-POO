package Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Model.*;
import Dao.ReservaDAO;

public class ReservaService {
	private ReservaDAO reservaDao; 
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	public ReservaService() {
		this.reservaDao = new ReservaDAO();
	}
	
	private int gerarId() {
        List<Reserva> lista = reservaDao.listar();    
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getId() + 1;
    }
	
	public String reservaCabineIndividual(CabineIndividual espaco, String datainicio, String datafim) {
		
		LocalDateTime inicio = ConverterData(datainicio);
		LocalDateTime fim = ConverterData(datafim);
		if (fim.isBefore(inicio)) {
			return "Erro data de fim antes do inicio";
		}
		else if(inicio.equals(fim)) {
			return "Erro data de inicio igual a data de fim";
		}
		else if(VerificarDatas(inicio, fim) == "Erro conflito") {
			return "Erro conflito de datas";
		} 

		Duration duracao = Duration.between(inicio, fim);
		long horas = duracao.toHours();
		double custo = espaco.calcularCustoReserva(horas);
		
		Reserva reserva = new Reserva(gerarId(), espaco, inicio, fim, custo,false);
		reservaDao.salvar(reserva);
	
		return "Reserva bem sucedida";
		
	}
	
	public String reservaAuditorio(Auditorio espaco, String datainicio, String datafim) {
		
		LocalDateTime inicio = ConverterData(datainicio);
		LocalDateTime fim = ConverterData(datafim);
		if (fim.isBefore(inicio)) {
			return "Erro data de fim antes do inicio";
		}
		else if(inicio.equals(fim)) {
			return "Erro data de inicio igual a data de fim";
		}
		else if(VerificarDatas(inicio, fim) == "Erro conflito") {
			return "Erro conflito de datas";
		} 

		Duration duracao = Duration.between(inicio, fim);
		long horas = duracao.toHours();
		double custo = espaco.calcularCustoReserva(horas);
		
		Reserva reserva = new Reserva(gerarId(), espaco, inicio, fim, custo,false);
		reservaDao.salvar(reserva);
	
		return "Reserva bem sucedida";
		
	}
	
	public String reservaSalaDeReuniao(SalaDeReuniao espaco, String datainicio, String datafim) {
		
		LocalDateTime inicio = ConverterData(datainicio);
		LocalDateTime fim = ConverterData(datafim);
		if (fim.isBefore(inicio)) {
			return "Erro data de fim antes do inicio";
		}
		else if(inicio.equals(fim)) {
			return "Erro data de inicio igual a data de fim";
		}
		else if(VerificarDatas(inicio, fim) == "Erro conflito") {
			return "Erro conflito de datas";
		} 

		Duration duracao = Duration.between(inicio, fim);
		long horas = duracao.toHours();
		double custo = espaco.calcularCustoReserva(horas);
		
		Reserva reserva = new Reserva(gerarId(), espaco, inicio, fim, custo,false);
		reservaDao.salvar(reserva);
	
		return "Reserva bem sucedida";
		
	}
	
	private LocalDateTime ConverterData(String data) {
		return LocalDateTime.parse(data, formato);
	}
	
	private String VerificarDatas(LocalDateTime inicio, LocalDateTime fim) {
		for (int i = 0; i < reservaDao.listar().size() ; i++ ) {
			if (inicio.isBefore(reservaDao.listar().get(i).getFim())) {
				return "Erro conflito";
			}
			else if (fim.isBefore(reservaDao.listar().get(i).getFim())) {
				return "Erro conflito";
			}		
		}
		return "Tudo certo"; 
	}
	
	public List<Reserva> listar() {
        return reservaDao.listar();
    }
	public Reserva buscarPorId(int id) {
        return reservaDao.buscar(id);
    }
}
