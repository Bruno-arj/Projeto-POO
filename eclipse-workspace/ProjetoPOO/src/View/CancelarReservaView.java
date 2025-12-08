package View;

import java.time.LocalDateTime;
import java.util.Scanner;
import Service.CancelamentoService;
import Service.ReservaService;
import Model.ReservaCabineIndividual;
import Model.ReservaAuditorio;
import Model.ReservaSalaDeReuniao;

public class CancelarReservaView {
    private static Scanner in = new Scanner(System.in);
    private static CancelamentoService cancelamentoService = new CancelamentoService();
    private static ReservaService reservaService = new ReservaService();
    private static int id;

    	public static void MenuCancelamento() {
    		int escolha = 0;
    		while (true) {
    		    try {
    		        System.out.println("\n--- Cancelamento de Reserva ---");
    		        System.out.println("Qual espaço pertence a reserva que deseja cancelar: ");
    		        System.out.println("1 - Cabine individual");
    		        System.out.println("2 - Auditório");
    		        System.out.println("3 - Sala de Reunião");
    		        System.out.print("Escolha: ");

    		        escolha = Integer.parseInt(in.nextLine());

    		        if (escolha >= 1 && escolha <= 3) {
    		            break;
    		        } else {
    		            System.out.println("\nOpção inválida! Digite apenas 1, 2 ou 3.\n");
    		        }

    		    } catch (Exception e) {
    		        System.out.println("\nEntrada inválida! Digite apenas números.\n");
    		    }
    		}
    		switch(escolha) {
    		case 1: 
    			CancelarReservaCabine();
    			break;
    		case 2:
    			CancelarReservaAuditorio();
    			break;
    		case 3:
    			CancelarReservaSalaDeReuniao();
    			break;
    		}
    	}
    	public static void CancelarReservaCabine() {
    		while (true) {
    	        try {
    	            System.out.print("\nDigite o ID da Reserva que deseja cancelar: ");
    	            id = Integer.parseInt(in.nextLine());
    	            break;

    	        } catch (Exception e) {
    	            System.out.println("\n⚠ Erro: digite um número inteiro válido para o ID.\n");
    	        }
    	    }
    	   ReservaCabineIndividual cabineIndividual = reservaService.buscarPorIdCabineIndividual(id);
    	   if(cabineIndividual.isCancelada() == true) {
    		   System.out.println("\nEstá Reserva já foi cancelada.");
    	   } else {
 	       System.out.println("\nReserva Encontrada:" + cabineIndividual.toString());
 	      LocalDateTime dataInicioReserva = cabineIndividual.getInicio();
	        LocalDateTime agora = LocalDateTime.now();
	        boolean menosDe24Horas = agora.isAfter(dataInicioReserva.minusHours(24));
	        
	        if (menosDe24Horas) {
	            System.out.println("A reserva está a menos de 24 horas devido a isso tera que pagar uma taxa dê R$ " + cabineIndividual.getValorCalculado()*0.2); 
	        } else {
	            System.out.println("A reserva está a mais de 24 horas então não será preciso pagar nada");
	        }
 	       while (true) {
 			    System.out.print("\nDeseja cancelar está reserva(sim/não)? ");
 			    String cancel = in.nextLine().trim(); 
 			    if (cancel.equalsIgnoreCase("sim")) {
 			    	cancelamentoService.cancelarReserva(id);
 			    	System.out.println("Reserva Cancelada Com sucesso");
 			        break;
 			    } else if (cancel.equalsIgnoreCase("não") || cancel.equalsIgnoreCase("nao")) {
 			        break;
 			    } else {
 			        System.out.println("Erro: responda apenas com 'Sim' ou 'Não'.");
 			    }
 			}
    	   }
    	}
    	public static void CancelarReservaAuditorio() {
    		while (true) {
    	        try {
    	            System.out.print("\nDigite o ID da Reserva que deseja cancelar: ");
    	            id = Integer.parseInt(in.nextLine());
    	            in.nextLine();
    	            break;

    	        } catch (Exception e) {
    	            System.out.println("\n⚠ Erro: digite um número inteiro válido para o ID.\n");
    	        }
    	       ReservaAuditorio Auditorio = reservaService.buscarPorIdAuditorio(id);
    	       if(Auditorio.isCancelada() == true) {
    	    	   System.out.print("Está reserva Já foi cancelada.");
    	       } else {
    	       System.out.println("\nReserva Encontrada:" + Auditorio.toString());
    	       LocalDateTime dataInicioReserva = Auditorio.getInicio();
    	        LocalDateTime agora = LocalDateTime.now();
    	        boolean menosDe24Horas = agora.isAfter(dataInicioReserva.minusHours(24));
    	        
    	        if (menosDe24Horas) {
    	            System.out.println("A reserva está a menos de 24 horas devido a isso tera que pagar uma taxa dê R$ " + Auditorio.getValorCalculado()*0.2); 
    	        } else {
    	            System.out.println("A reserva está a mais de 24 horas então não será preciso pagar nada");
    	        }
    	       while (true) {
    			    System.out.print("\nDeseja cancelar está reserva(Sim/Não)? ");
    			    String cancel = in.nextLine().trim(); 
    			    if (cancel.equalsIgnoreCase("sim")) {
    			    	cancelamentoService.cancelarReserva(id);
    			    	System.out.println("Reserva Cancelada Com sucesso");
    			        break;
    			    } else if (cancel.equalsIgnoreCase("não") || cancel.equalsIgnoreCase("nao")) {
    			        break;
    			    } else {
    			        System.out.println("Erro: responda apenas com 'Sim' ou 'Não'.");
    			    }
    			}
    	    }
    		}
    	}
    	public static void CancelarReservaSalaDeReuniao() {
    		while (true) {
    	        try {
    	            System.out.print("\nDigite o ID da Reserva que deseja cancelar: ");
    	            id = Integer.parseInt(in.nextLine());
    	            in.nextLine();
    	            break;

    	        } catch (Exception e) {
    	            System.out.println("\n⚠ Erro: digite um número inteiro válido para o ID.\n");
    	        }
    	       ReservaSalaDeReuniao SalaDeReuniao = reservaService.buscarPorIdSalaDeReuniao(id);
    	       if(SalaDeReuniao.isCancelada() == true) {
    	    	   System.out.println("Está reserva já foi cancelada.");
    	       } else {
    	       System.out.println("\nReserva Encontrada:" + SalaDeReuniao.toString());
    	       LocalDateTime dataInicioReserva = SalaDeReuniao.getInicio();
   	        LocalDateTime agora = LocalDateTime.now();
   	        boolean menosDe24Horas = agora.isAfter(dataInicioReserva.minusHours(24));
   	        
   	        if (menosDe24Horas) {
   	            System.out.println("A reserva está a menos de 24 horas devido a isso tera que pagar uma taxa dê R$ " + SalaDeReuniao.getValorCalculado()*0.2); 
   	        } else {
   	            System.out.println("A reserva está a mais de 24 horas então não será preciso pagar nada");
   	        }
    	       while (true) {
    			    System.out.print("\nDeseja cancelar está reserva? (Sim/Não)? ");
    			    String cancel = in.nextLine().trim(); 
    			    if (cancel.equalsIgnoreCase("sim")) {
    			    	cancelamentoService.cancelarReserva(id);
    			    	System.out.println("Reserva Cancelada Com sucesso");
    			        break;
    			    } else if (cancel.equalsIgnoreCase("não") || cancel.equalsIgnoreCase("nao")) {
    			        break;
    			    } else {
    			        System.out.println("Erro: responda apenas com 'Sim' ou 'Não'.");
    			    }
    			}
    	       }
    	    }
    	}
    	
}