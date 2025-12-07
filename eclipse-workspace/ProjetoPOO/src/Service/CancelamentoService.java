package Service;
import Model.Reserva;
import java.time.LocalDateTime;

public class CancelamentoService {
	public double VerificarHoras(Reserva reserva) {
		LocalDateTime dataReserva = reserva.getInicio();
		LocalDateTime agora = LocalDateTime.now();
		boolean eh24horasantes = agora.isAfter(dataReserva.minusHours(24));
		
		if(eh24horasantes) {
			return reserva.getValorCalculado()+(reserva.getValorCalculado()*0.2);
		} else {
			return 0;
		}
		
	}
	
	public String Cancelamento(Reserva reserva) {
		if(VerificarHoras(reserva) != 0) {
			reserva.setCancelada(true);
			return "Reserva cancelada com pagamento de taxa";
		} else {
			reserva.setCancelada(true);
			return "Reserva cancelada sem pagamento de taxa";
		}
	}
}
