package View;
import Service.*;
public class Main {

	public static void main(String[] args) {
		ReservaCabineIndividualService service = new ReservaCabineIndividualService();
		ReservaAuditorioService serviceAuditorio = new ReservaAuditorioService();
		ReservaSalaDeReuniaoService serviceSalaDeReuniao = new ReservaSalaDeReuniaoService();
		CancelamentoService cancelamento = new CancelamentoService();
		
		System.out.println(service.ReservaCabine(0, "Kauã", 1, false, "08/12/2025 20:12", "11/12/2025 20:50"));
		System.out.println(serviceAuditorio.ReservaAuditorio(0, "Kauã", 1, false, "10/11/2025 20:50", "11/11/2025 20:50"));
		System.out.println(serviceSalaDeReuniao.ReservaSalaDeReuniao(0, "Kauã", 1, false, false, "10/11/2025 20:50", "11/11/2025 20:50"));
		System.out.println(serviceSalaDeReuniao.ReservaSalaDeReuniao(0, "Kauã", 1, false, false, "09/11/2025 20:50", "20/11/2025 20:50"));
		System.out.println(service.getListaIndividual().get(0));
		System.out.println(cancelamento.Cancelamento(service.getListaIndividual().get(0)));
	}

}
