package Service;
import java.util.List;

import Dao.CabineIndividualDAO;
import Dao.AuditorioDAO;
import Dao.SalaDeReuniaoDAO;
import Model.*;

public class EspacoDificilService {
	private CabineIndividualDAO CabineIndividualDAO;
	private AuditorioDAO AuditorioDAO;
	private SalaDeReuniaoDAO SalaDeReuniaoDAO;

    public EspacoDificilService() {
        this.CabineIndividualDAO = new CabineIndividualDAO();
        this.AuditorioDAO = new AuditorioDAO();
        this.SalaDeReuniaoDAO = new SalaDeReuniaoDAO();
    }

    private int gerarId() {
        List<CabineIndividual> lista = CabineIndividualDAO.listar();
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getId() + 1;
    }
    
	public void cabineindividual(int id, String nome, int capacidade, boolean disponivel) {
		CabineIndividual cabineIndividual = new CabineIndividual(gerarId(),nome,1,false);
		CabineIndividualDAO.salvar(cabineIndividual);
	}
	
	public void auditorio(int id, String nome, int capacidade, boolean disponivel) {
		Auditorio auditorio = new Auditorio(gerarId(),nome,capacidade,false);
		AuditorioDAO.salvar(auditorio);
	}
	
	public void salaDeReuniao(int id, String nome, int capacidade, boolean disponivel,boolean projetor) {
		SalaDeReuniao salaDeReuniao = new SalaDeReuniao(gerarId(),nome,1,false,projetor);
		SalaDeReuniaoDAO.salvar(salaDeReuniao);
	}
	
	public List<CabineIndividual> listarIndividual() {
        return CabineIndividualDAO.listar();
    }
	
	public List<Auditorio> listarAuditorio() {
        return AuditorioDAO.listar();
    }
	public List<SalaDeReuniao> listarSalaDeReuniao() {
        return SalaDeReuniaoDAO.listar();
    }

    public CabineIndividual buscarPorIdCabineIndividual(int id) {
        return CabineIndividualDAO.buscar(id);
    }
    public Auditorio buscarPorIdAuditorio(int id) {
        return AuditorioDAO.buscar(id);
    }
    public SalaDeReuniao buscarPorIdSalaDeReuniao(int id) {
        return SalaDeReuniaoDAO.buscar(id);
    }
}
