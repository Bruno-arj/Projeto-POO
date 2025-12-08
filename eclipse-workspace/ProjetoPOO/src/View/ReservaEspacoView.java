package View;

import java.util.Scanner;

public class ReservaEspacoView {
	static Scanner in = new Scanner(System.in);
	public static void MenuReserva() {
		int escolha = 0;

		while (true) {
		    try {
		        System.out.println("\n--- Reserva de Espaço ---");    [
		                                                               .out.print("Digite o id do espaço que deseja reserva: ");
		        escolha = Integer.parseInt(in.nextLine());

		        if (escolha >= 0) {
		            break;
		        } else {
		            System.out.println("\nOpção inválida! Digite apenas números positivos \n");
		        }

		    } catch (Exception e) {
		        System.out.println("\nEntrada inválida! Digite apenas números.\n");
		    }
		}
		System.out.print("Reserva                                                                       ");
	}
}
