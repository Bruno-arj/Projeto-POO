
package Service;

import java.time.LocalDateTime;
import java.util.List;
import Dao.PagamentoDAO;
import Model.Pagamento;
import Model.Reserva;
import Model.ReservaAuditorio;
import Model.ReservaCabineIndividual;
import Model.ReservaSalaDeReuniao;

public class PagamentoService {
    private ReservaService reservaService;
    private PagamentoDAO pagamentoDAO;

    public PagamentoService() {
        this.reservaService = new ReservaService();
        this.pagamentoDAO = new PagamentoDAO();
    }


    private int gerarId() {
        List<Pagamento> lista = pagamentoDAO.listar();
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getId() + 1;
    }

    public void registrarPagamentoCabine(int idReserva, String metodo) {

        ReservaCabineIndividual reserva = reservaService.buscarPorIdCabineIndividual(idReserva);
        

        if (reserva == null) {
            throw new IllegalArgumentException("Erro: Reserva com ID " + idReserva + " não encontrada.");
        }


        for (Pagamento p : pagamentoDAO.listar()) {
            if (p.getIdReserva() == idReserva) {
                throw new IllegalArgumentException("Erro: Esta reserva já possui um pagamento registrado.");
            }
        }
        
    
        double valorASerPago = reserva.getValorCalculado();

      
        Pagamento pagamento = new Pagamento(
            gerarId(), 
            idReserva, 
            valorASerPago, 
            LocalDateTime.now(), 
            metodo
        );

        pagamentoDAO.salvar(pagamento);
    }
    
    public void registrarPagamentoAuditorio(int idReserva, String metodo) {

        ReservaAuditorio reserva = reservaService.buscarPorIdAuditorio(idReserva);
        

        if (reserva == null) {
            throw new IllegalArgumentException("Erro: Reserva com ID " + idReserva + " não encontrada.");
        }


        for (Pagamento p : pagamentoDAO.listar()) {
            if (p.getIdReserva() == idReserva) {
                throw new IllegalArgumentException("Erro: Esta reserva já possui um pagamento registrado.");
            }
        }
        
    
        double valorASerPago = reserva.getValorCalculado();

      
        Pagamento pagamento = new Pagamento(
            gerarId(), 
            idReserva, 
            valorASerPago, 
            LocalDateTime.now(), 
            metodo
        );

        pagamentoDAO.salvar(pagamento);
    }
    
    public void registrarPagamentoSalaDeReuniao(int idReserva, String metodo) {

        ReservaSalaDeReuniao reserva = reservaService.buscarPorIdSalaDeReuniao(idReserva);
        

        if (reserva == null) {
            throw new IllegalArgumentException("Erro: Reserva com ID " + idReserva + " não encontrada.");
        }


        for (Pagamento p : pagamentoDAO.listar()) {
            if (p.getIdReserva() == idReserva) {
                throw new IllegalArgumentException("Erro: Esta reserva já possui um pagamento registrado.");
            }
        }
        
    
        double valorASerPago = reserva.getValorCalculado();

      
        Pagamento pagamento = new Pagamento(
            gerarId(), 
            idReserva, 
            valorASerPago, 
            LocalDateTime.now(), 
            metodo
        );

        pagamentoDAO.salvar(pagamento);
    }

    
    public List<Pagamento> listarPagamentos() {
        return pagamentoDAO.listar();
    }
}
