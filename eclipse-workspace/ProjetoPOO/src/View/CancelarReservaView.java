package View;

import java.util.Scanner;

public class CancelarReservaView {
	static Scanner in = new Scanner(System.in);
	public static void Cancelar() {
		int idReserva = -1;

		System.out.println("\n--- Cancelar Reserva ---");

		while (true) {
		    System.out.print("Digite o ID da reserva que deseja cancelar: ");

		    try {
		        idReserva = in.nextInt();
		        in.nextLine();

		        if (idReserva >= 0) {
		            break;
		        } else {
		            System.out.println("Erro: o ID deve ser um número maior que zero.");
		        }

		    } catch (Exception e) {
		        System.out.println("Erro: digite apenas números inteiros.");
		        in.nextLine(); 
		    }
		}
		while (true) {
		    System.out.print("\nTem certeza(sim/não)? ");
		    String certeza = in.nextLine().trim();
		    if (certeza.equalsIgnoreCase("sim")) {
		        ;
		        break;
		    } else if (certeza.equalsIgnoreCase("não") || certeza.equalsIgnoreCase("nao")) {
		        System.out.println("\nAção cancelada");
		        break;
		    } else {
		        System.out.println("Erro: responda apenas com 'Sim' ou 'Não'.");
		    }
		}
	}
}
