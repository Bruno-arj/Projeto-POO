package Service;
import Model.CabineIndividual;

import java.util.ArrayList;

import Model.Auditorio;
import Model.SalaDeReuniao;

public class ReservaService {
	ArrayList<CabineIndividual> listaIndividual = new ArrayList<CabineIndividual>();
	ArrayList<Auditorio> listaAuditorio = new ArrayList<Auditorio>();
	ArrayList<SalaDeReuniao> listaSalaDeReuniao = new ArrayList<SalaDeReuniao>();
	
	
	
	public CabineIndividual ReservaCabine(int id, String nome, int capacidade, boolean disponivel) {
		CabineIndividual cabineIndividual = new CabineIndividual(id,nome,capacidade,disponivel);
		AdicionarListaCabine(cabineIndividual);
		return cabineIndividual;
	}
	public Auditorio ReservaAuditorio(int id, String nome, int capacidade, boolean disponivel) {
		Auditorio auditorio = new Auditorio(id, nome, capacidade, disponivel);
		AdicionarListaAuditorio(auditorio);
		return auditorio;
	}
	public SalaDeReuniao ReservaSalaDeReuniao(int id, String nome, int capacidade, boolean disponivel, boolean projetor) {
		SalaDeReuniao salaDeReuniao = new SalaDeReuniao(id, nome, capacidade, disponivel, projetor);
		AdicionarListaSalaDeReuniao(salaDeReuniao);
		return salaDeReuniao;
	}
	
	private void AdicionarListaCabine(CabineIndividual cabineIndividual) {
		listaIndividual.add(cabineIndividual);
	}
	private void AdicionarListaAuditorio(Auditorio auditorio) {
		listaAuditorio.add(auditorio);
	}
	private void AdicionarListaSalaDeReuniao(SalaDeReuniao salaDeReuniao) {
		listaSalaDeReuniao.add(salaDeReuniao);
	}
	public ArrayList<CabineIndividual> getListaIndividual() {
		return listaIndividual;
	}
	public ArrayList<Auditorio> getListaAuditorio() {
		return listaAuditorio;
	}
	public ArrayList<SalaDeReuniao> getListaSalaDeReuniao() {
		return listaSalaDeReuniao;
	}
	
}
