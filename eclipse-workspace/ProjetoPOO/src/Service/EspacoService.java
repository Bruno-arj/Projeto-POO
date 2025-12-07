package Service;

import java.util.List;
import Dao.EspacoDAO;
import Model.Espaco;

public class EspacoService {

    private EspacoDAO espacoDAO;

    public EspacoService() {
        this.espacoDAO = new EspacoDAO();
    }


    private int gerarId() {
        List<Espaco> lista = espacoDAO.listar();
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getId() + 1;
    }


    public void cadastrar(Espaco espaco) {

        if (espaco.getNome() == null)
            throw new IllegalArgumentException("Nome não pode ser vazio");

        if (espaco.getCapacidade() <= 0)
            throw new IllegalArgumentException("Capacidade inválida");
        
        espaco.setId(gerarId());

        espacoDAO.salvar(espaco);
    }


    public List<Espaco> listar() {
        return espacoDAO.listar();
    }


    public Espaco buscarPorId(int id) {
        return espacoDAO.buscar(id);
    }


    public void editar(int id, String nome, int capacidade) {
        Espaco espaco = espacoDAO.buscar(id);

        if (espaco == null)
            throw new IllegalArgumentException("Espaço não encontrado.");

        espaco.setNome(nome);
        espaco.setCapacidade(capacidade);

        espacoDAO.editar(espaco);
    }


    public void remover(int id) {
        espacoDAO.remover(id);
    }
}
