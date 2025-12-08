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

    private int gerarIdCabineIndividual() {
        List<CabineIndividual> lista = CabineIndividualDAO.listar();
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getId() + 1;
    }
    private int gerarIdAuditorio() {
        List<Auditorio> lista = AuditorioDAO.listar();
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getId() + 1;
    }
    private int gerarIdSalaDeReuniao() {
        List<SalaDeReuniao> lista = SalaDeReuniaoDAO.listar();
        return lista.isEmpty() ? 1 : lista.get(lista.size() - 1).getId() + 1;
    }
    
	public CabineIndividual cabineindividual(int id, String nome, int capacidade, boolean disponivel) {
		CabineIndividual cabineIndividual = new CabineIndividual(gerarIdCabineIndividual(),nome,1,false);
		CabineIndividualDAO.salvar(cabineIndividual);
		return cabineIndividual;
	}
	
	public void auditorio(int id, String nome, int capacidade, boolean disponivel) {
		Auditorio auditorio = new Auditorio(gerarIdAuditorio(),nome,capacidade,false);
		AuditorioDAO.salvar(auditorio);
	}
	
	public void salaDeReuniao(int id, String nome, int capacidade, boolean disponivel,boolean projetor) {
		SalaDeReuniao salaDeReuniao = new SalaDeReuniao(gerarIdSalaDeReuniao(),nome,1,false,projetor);
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
