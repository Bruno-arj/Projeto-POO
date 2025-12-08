package Service;
import java.time.LocalDateTime;
import java.util.List;
import Dao.PagamentoDAO;
import Model.Pagamento;

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
	public void Pagamento(int id, int idReserva, double valorPago, LocalDateTime dataPagamento, 
								 String metodo) {
		
		double valorReserva = reservaService.buscarPorId(idReserva).getValorCalculado();
		Pagamento pagamento = new Pagamento(gerarId(),idReserva,valorReserva,dataPagamento,metodo);
		pagamentoDAO.salvar(pagamento);
	}
}
