package View;
import Service.*;
import java.util.Scanner;
import Service.EspacoDificilService;

public class CadastroEspacoView {
	static Scanner in = new Scanner(System.in);
	static EspacoDificilService service = new EspacoDificilService();
	
	public static void MostrarCadastro() {
		int escolha = 0;

		while (true) {
		    try {
		        System.out.println("\nQual espaço deseja cadastrar? ");
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
	public static void Cabineindividual() {
		System.out.println("\n--- Reserva de uma Cabine individual ---");
		String nome = "";
		while (true) {
		    System.out.print("Informe o nome do espaço: ");
		    nome = in.nextLine().trim();
		    if (!nome.isEmpty()) {
		        break;
		    }
		    System.out.println("Erro: o nome não pode estar vazio. Tente novamente.");
		}
		service.cabineindividual(0, nome, 0, false);

	}
	public static void Auditorio() {
		System.out.println("\n--- Reserva de um Auditório ---");
		String nome = "";
		while (true) {
		    System.out.print("Informe o nome do espaço: ");
		    nome = in.nextLine().trim();
		    if (!nome.isEmpty()) {
		        break;
		    }
		    System.out.println("Erro: o nome não pode estar vazio. Tente novamente.");
		}
		int capacidade = 0;
		while (true) {
		    System.out.print("\nInforme a capacidade: ");
		    try {
		        capacidade = in.nextInt();
		        in.nextLine(); 
		        if (capacidade <= 0) {
		            break;
		        } else {
		            System.out.println("Erro: a capacidade deve ser maior que zero.");
		        }
		    } catch (Exception e) {
		        System.out.println("Erro: digite apenas números inteiros.");
		        in.nextLine();
		    }
		}
		service.auditorio(0, nome, capacidade, false);
	}
	public static void SalaDeReuniao() {
		boolean projetor = false;
		System.out.println("\n--- Reserva de uma Sala de Reunião ---");
		String nome = "";
		while (true) {
		    System.out.print("Informe o nome do espaço: ");
		    nome = in.nextLine().trim();
		    if (!nome.isEmpty()) {
		        break;
		    }
		    System.out.println("Erro: o nome não pode estar vazio. Tente novamente.");
		}
		int capacidade = 0;
		while (true) {
		    System.out.print("\nInforme a capacidade: ");
		    try {
		        capacidade = in.nextInt();
		        in.nextLine(); 
		        if (capacidade > 0) {
		            break;
		        } else {
		            System.out.println("Erro: a capacidade deve ser maior que zero.");
		        }
		    } catch (Exception e) {
		        System.out.println("Erro: digite apenas números inteiros.");
		        in.nextLine(); 
		    }
		}
		while (true) {
		    System.out.print("\nA sala possui projetor (Sim/Não)? ");
		    String temProjetor = in.nextLine().trim();
		    if (temProjetor.equalsIgnoreCase("sim")) {
		        projetor = true;
		        break;
		    } else if (temProjetor.equalsIgnoreCase("não") || temProjetor.equalsIgnoreCase("nao")) {
		        projetor = false;
		        break;
		    } else {
		        System.out.println("Erro: responda apenas com 'Sim' ou 'Não'.");
		    }
		}
		service.salaDeReuniao(0, nome, capacidade, projetor, projetor);

	}
}
