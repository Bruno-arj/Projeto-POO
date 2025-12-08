package View;
import Service.ReservaService;

import java.util.InputMismatchException;
import java.util.Scanner;
import Service.EspacoDificilService;
import Model.*;

public class ReservaEspacoView {
	static ReservaService service = new ReservaService();
	static Scanner in = new Scanner(System.in);
	
	public static void MenuReserva() {
		int escolha = 0;
		while (true) {
		    try {
		        System.out.println("\n--- Reserva de Espaço ---");
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
			CadastroEspacoView.Cabineindividual();
			break;
		case 2:
			CadastroEspacoView.Auditorio();
			break;
		case 3:
			CadastroEspacoView.SalaDeReuniao();
			break;
		}
	}
	
	public static void ReservaCabineIndividualInput(CabineIndividual canineIndivual) {
		String dataInicio = "";
		String dataFim = "";
		int id = 0;
		
		while (true) {
		    try {
		        System.out.print("\nDigite o ID da Cabine Individual que deseja reservar: ");
		        id = in.nextInt();
		        in.nextLine();
		        break;
		    } catch (InputMismatchException e) {
		        System.out.println("⚠ Por favor, digite um número válido.");
		        in.nextLine();
		    }
		    
		    System.out.print("\nDigite a data de início (dia/mês/ano): ");
		    dataInicio = in.nextLine();

		    System.out.print("\nDigite o horário de começo do evento (hora:minuto): ");
		    dataInicio = dataInicio + " " + in.nextLine();

		    System.out.print("\nDigite a data de encerramento (dia/mês/ano): ");
		    dataFim = in.nextLine();

		    System.out.print("\nDigite o horário de fechamento do evento (hora:minuto): ");
		    dataFim = dataFim + " " + in.nextLine();
		    
		}   
	}
	public static void ReservaCabineIndividual(CabineIndividual cabinieIndividual, String dataInicio ,String dataFim) {
		service.reserva(cabinieIndividual, dataInicio, dataFim);
	}
}
