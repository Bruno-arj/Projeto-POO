package View;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import Model.Auditorio;
import Model.CabineIndividual;
import Model.SalaDeReuniao;
import Service.EspacoDificilService;
import Service.ReservaService;

public class ReservaEspacoView {
	static ReservaService service = new ReservaService();
	static EspacoDificilService espaco = new EspacoDificilService();
	static Scanner in = new Scanner(System.in);
	
	public static void MenuReserva() {
		int escolha = 0;
		while (true) {
		    try {
		        System.out.println("\n--- Reserva de Espaço ---a");
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
			ReservaCabineIndividual();
			break;
		case 2:
			ReservaAuditorio();
			break;
		case 3:
			ReservaSalaDeReuniao();
			break;
		}
	}
	
	public static void ReservaCabineIndividual() {
	    int id = 0;
	    String dataInicio = "";
	    String dataFim = "";

	    while (true) {
	        try {
	            System.out.print("\nDigite o ID da Cabine Individual que deseja reservar: ");
	            id = Integer.parseInt(in.nextLine());
	            break;

	        } catch (Exception e) {
	            System.out.println("\n⚠ Erro: digite um número inteiro válido para o ID.\n");
	        }
	    }

	    while (true) {
	        try {
	            System.out.print("\nDigite a data de início (dia/mês/ano): ");
	            String data = in.nextLine();

	            System.out.print("Digite o horário de início (hora:minuto): ");
	            String hora = in.nextLine();

	            dataInicio = data + " " + hora;
	            break;

	        } catch (Exception e) {
	            System.out.println("\n⚠ Data ou horário inválidos! Use o formato correto: dia/Mês/ano e Hora:Minuto.\n");
	        }
	    }

	    while (true) {
	        try {
	            System.out.print("\nDigite a data de encerramento (dia/mês/ano): ");
	            String data = in.nextLine();

	            System.out.print("Digite o horário de encerramento (hora:minuto): ");
	            String hora = in.nextLine();

	            dataFim = data + " " + hora;
	            break;

	        } catch (Exception e) {
	            System.out.println("\n⚠ Data ou horário inválidos! Use o formato correto: dia/Mês/ano e Hora:Minuto.\n");
	        }
	    }

	    CabineIndividual cabine = espaco.buscarPorIdCabineIndividual(id);
	    String msg = service.reservaCabineIndividual(cabine, dataInicio, dataFim);

	    System.out.println("\n→ " + msg);
	}

	public static void ReservaAuditorio() {
	    String dataInicio = "";
	    String dataFim = "";
	    int id = 0;

	    while (true) {
	        try {
	            System.out.print("\nDigite o ID do Auditório que deseja reservar: ");
	            id = Integer.parseInt(in.nextLine());
	            break;

	        } catch (Exception e) {
	            System.out.println("⚠ Erro: digite um número inteiro válido.");
	        }
	    }

	    while (true) {
	        try {
	            System.out.print("\nDigite a data de início (dia/mês/ano): ");
	            String data = in.nextLine();

	            System.out.print("Digite o horário de começo do evento (hora:minuto): ");
	            String hora = in.nextLine();

	            dataInicio = data + " " + hora;
	            break;

	        } catch (Exception e) {
	            System.out.println("⚠ Data ou horário inválidos! Use o formato dd/MM/yyyy HH:mm.\n");
	        }
	    }

	    while (true) {
	        try {
	            System.out.print("\nDigite a data de encerramento (dia/mês/ano): ");
	            String data = in.nextLine();

	            System.out.print("Digite o horário de fechamento do evento (hora:minuto): ");
	            String hora = in.nextLine();

	            dataFim = data + " " + hora;
	            break;

	        } catch (Exception e) {
	            System.out.println("⚠ Data ou horário inválidos! Use o formato dd/MM/yyyy HH:mm.\n");
	        }
	    }

	    Auditorio auditorio = espaco.buscarPorIdAuditorio(id);
	    String msg = service.reservaAuditorio(auditorio, dataInicio, dataFim);

	    System.out.println("\n→ " + msg);
	}

	
	public static void ReservaSalaDeReuniao() {
		String dataInicio = "";
	    String dataFim = "";
	    int id = 0;

	    while (true) {
	        try {
	            System.out.print("\nDigite o ID da Sala De Reunião que deseja reservar: ");
	            id = Integer.parseInt(in.nextLine());
	            break;

	        } catch (Exception e) {
	            System.out.println("⚠ Erro: digite um número inteiro válido.");
	        }
	    }

	    while (true) {
	        try {
	            System.out.print("\nDigite a data de início (dia/mês/ano): ");
	            String data = in.nextLine();

	            System.out.print("Digite o horário de começo do evento (hora:minuto): ");
	            String hora = in.nextLine();

	            dataInicio = data + " " + hora;
	            break;

	        } catch (Exception e) {
	            System.out.println("⚠ Data ou horário inválidos! Use o formato dd/MM/yyyy HH:mm.\n");
	        }
	    }

	    while (true) {
	        try {
	            System.out.print("\nDigite a data de encerramento (dia/mês/ano): ");
	            String data = in.nextLine();

	            System.out.print("Digite o horário de fechamento do evento (hora:minuto): ");
	            String hora = in.nextLine();

	            dataFim = data + " " + hora;
	            break;

	        } catch (Exception e) {
	            System.out.println("⚠ Data ou horário inválidos! Use o formato dd/MM/yyyy HH:mm.\n");
	        }
	    }

	    SalaDeReuniao salaDeReuniao = espaco.buscarPorIdSalaDeReuniao(id);
	    String msg = service.reservaSalaDeReuniao(salaDeReuniao, dataInicio, dataFim);

	    System.out.println("\n→ " + msg);
	}
}
