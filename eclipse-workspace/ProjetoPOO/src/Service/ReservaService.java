package Service;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import Model.Espaco;
import Model.Reserva;
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
	
	public String reserva(Espaco espaco, String datainicio, String datafim, 
			double valorCalculado,boolean cancelada) {
		
		LocalDateTime inicio = ConverterData(datainicio);
		LocalDateTime fim = ConverterData(datafim);
		if (fim.isBefore(inicio)) {
			return "Erro throws quando der certo coloca pra retorna o preco";
		}
		else if(inicio.equals(fim)) {
			return "Erro throws quando der certo coloca pra retorna preco";
		}
		else if(VerificarDatas(inicio, fim) == "Erro conflito") {
			return "Erro conflito";
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
}
