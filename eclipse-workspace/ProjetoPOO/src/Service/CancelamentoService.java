package Service;

import Dao.ReservaDAO;
import Model.Reserva;
import java.time.LocalDateTime;

public class CancelamentoService {
    
    private ReservaDAO reservaDAO;

    public CancelamentoService() {
        this.reservaDAO = new ReservaDAO();
    }

    public double calcularTaxaCancelamento(Reserva reserva) {
        LocalDateTime dataInicioReserva = reserva.getInicio();
        LocalDateTime agora = LocalDateTime.now();
        
        boolean menosDe24Horas = agora.isAfter(dataInicioReserva.minusHours(24));
        
        if (menosDe24Horas) {
            return reserva.getValorCalculado() * 0.20; 
        } else {
            return 0.0;
        }
    }
    
    public String cancelarReserva(int idReserva) {
        Reserva reserva = reservaDAO.buscar(idReserva);
        
        if (reserva == null) {
            return "Erro: Reserva não encontrada.";
        }
        
        if (reserva.isCancelada()) {
            return "Erro: Esta reserva já foi cancelada anteriormente.";
        }

        double taxa = calcularTaxaCancelamento(reserva);
        
        reserva.setCancelada(true);
        
        reservaDAO.editar(reserva);
        
        if (taxa > 0) {
            return String.format("Reserva cancelada com sucesso. Taxa de cancelamento aplicada: R$ %.2f (menos de 24h de antecedência).", taxa);
        } else {
            return "Reserva cancelada com sucesso. Sem custos (cancelamento antecipado).";
        }
    }
}