package View;
import Service.*;
public class Main {

	public static void main(String[] args) {
		ReservaCabineIndividualService service = new ReservaCabineIndividualService();
		ReservaAuditorioService serviceAuditorio = new ReservaAuditorioService();
		ReservaSalaDeReuniaoService serviceSalaDeReuniao = new ReservaSalaDeReuniaoService(); 
		
		System.out.println(service.ReservaCabine(0, "Kauã", 1, false, "09/11/2025 20:50", "11/11/2025 20:50"));
		System.out.println(serviceAuditorio.ReservaAuditorio(0, "Kauã", 1, false, "10/11/2025 20:50", "11/11/2025 20:50"));
		System.out.println(serviceSalaDeReuniao.ReservaSalaDeReuniao(0, "Kauã", 1, false, false, "10/11/2025 20:50", "11/11/2025 20:50"));
		System.out.println(serviceSalaDeReuniao.ReservaSalaDeReuniao(0, "Kauã", 1, false, false, "09/11/2025 20:50", "20/11/2025 20:50"));
		System.out.println(service.toString());
		
		System.out.println(serviceAuditorio.toString());
		System.out.print(serviceSalaDeReuniao.toString());
	}

}
