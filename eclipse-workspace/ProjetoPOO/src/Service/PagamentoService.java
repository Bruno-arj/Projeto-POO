package Service;

import java.time.LocalDateTime;
import java.util.List;
import Dao.PagamentoDAO;
import Model.Pagamento;
import Model.Reserva;

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

    public void registrarPagamento(int idReserva, String metodo) {

        Reserva reserva = reservaService.buscarPorId(idReserva);
        

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