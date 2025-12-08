package Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Model.*;
import Dao.*;

public class ReservaService {
	private ReservaAuditorioDAO reservaAuditorioDAO;
	private ReservaCabineIndividualDAO reservaCabineIndividualDAO;
	private ReservaSalaDeReuniaoDAO reservaSalaDeReuniaoDAO;
	DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
	
	public ReservaService() {
		this.reservaAuditorioDAO = new ReservaAuditorioDAO();
		this.reservaCabineIndividualDAO = new ReservaCabineIndividualDAO();
		this.reservaSalaDeReuniaoDAO = new ReservaSalaDeReuniaoDAO();
	}
	
	private int gerarIdAuditorio() {
        List<ReservaAuditorio> lista = reservaAuditorioDAO.listar();    
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getId() + 1;
    }
	
	private int gerarIdCabineIndividual() {
        List<ReservaCabineIndividual> lista = reservaCabineIndividualDAO.listar();    
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getId() + 1;
    }
	
	private int gerarIdSalaDeReuniao() {
        List<ReservaSalaDeReuniao> lista = reservaSalaDeReuniaoDAO.listar();    
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
		else if(VerificarDatasCabineIndividual(inicio, fim) == "Erro conflito") {
			return "Erro conflito de datas";
		} 

		Duration duracao = Duration.between(inicio, fim);
		long horas = duracao.toHours();
		double custo = espaco.calcularCustoReserva(horas);
		
		ReservaCabineIndividual reserva = new ReservaCabineIndividual(gerarIdCabineIndividual(), espaco, inicio, fim, custo,false);
		reservaCabineIndividualDAO.salvar(reserva);
	
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
		else if(VerificarDatasAuditorio(inicio, fim) == "Erro conflito") {
			return "Erro conflito de datas";
		} 

		Duration duracao = Duration.between(inicio, fim);
		long horas = duracao.toHours();
		double custo = espaco.calcularCustoReserva(horas);
		
		ReservaAuditorio reserva = new ReservaAuditorio(gerarIdAuditorio(), espaco, inicio, fim, custo,false);
		reservaAuditorioDAO.salvar(reserva);
	
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
		else if(VerificarDatasSalaDeReuniao(inicio, fim) == "Erro conflito") {
			return "Erro conflito de datas";
		} 

		Duration duracao = Duration.between(inicio, fim);
		long horas = duracao.toHours();
		double custo = espaco.calcularCustoReserva(horas);
		
		ReservaSalaDeReuniao reserva = new ReservaSalaDeReuniao(gerarIdSalaDeReuniao(), espaco, inicio, fim, custo,false);
		reservaSalaDeReuniaoDAO.salvar(reserva);
	
		return "Reserva bem sucedida";
		
	}
	
	private LocalDateTime ConverterData(String data) {
		return LocalDateTime.parse(data, formato);
	}
	
	private String VerificarDatasCabineIndividual(LocalDateTime inicio, LocalDateTime fim) {
		for (int i = 0; i < reservaCabineIndividualDAO.listar().size() ; i++ ) {
			if (inicio.isBefore(reservaCabineIndividualDAO.listar().get(i).getFim())) {
				return "Erro conflito";
			}
			else if (fim.isBefore(reservaCabineIndividualDAO.listar().get(i).getFim())) {
				return "Erro conflito";
			}		
		}
		return "Tudo certo";
	}
	private String VerificarDatasAuditorio(LocalDateTime inicio, LocalDateTime fim) {
		for (int i = 0; i < reservaAuditorioDAO.listar().size() ; i++ ) {
			if (inicio.isBefore(reservaAuditorioDAO.listar().get(i).getFim())) {
				return "Erro conflito";
			}
			else if (fim.isBefore(reservaAuditorioDAO.listar().get(i).getFim())) {
				return "Erro conflito";
			}		
		}
		return "Tudo certo"; 
	}
	private String VerificarDatasSalaDeReuniao(LocalDateTime inicio, LocalDateTime fim) {
		for (int i = 0; i < reservaSalaDeReuniaoDAO.listar().size() ; i++ ) {
			if (inicio.isBefore(reservaSalaDeReuniaoDAO.listar().get(i).getFim())) {
				return "Erro conflito";
			}
			else if (fim.isBefore(reservaSalaDeReuniaoDAO.listar().get(i).getFim())) {
				return "Erro conflito";
			}		
		}
		return "Tudo certo"; 
	}
	
	public List<ReservaCabineIndividual> listarCabineIndividual() {
        return reservaCabineIndividualDAO.listar();
    }
	public List<ReservaAuditorio> listarAuditorio() {
        return reservaAuditorioDAO.listar();
    }
	public List<ReservaSalaDeReuniao> listarSalaDeReuniao() {
        return reservaSalaDeReuniaoDAO.listar();
    }
	public ReservaCabineIndividual buscarPorIdCabineIndividual(int id) {
        return reservaCabineIndividualDAO.buscar(id);
    }
	public ReservaAuditorio buscarPorIdAuditorio(int id) {
        return reservaAuditorioDAO.buscar(id);
    }
	public ReservaSalaDeReuniao buscarPorIdSalaDeReuniao(int id) {
        return reservaSalaDeReuniaoDAO.buscar(id);
    }
}
