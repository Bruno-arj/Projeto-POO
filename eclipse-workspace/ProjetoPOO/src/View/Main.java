package View;
import Service.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
				Scanner in = new Scanner(System.in);
				int menu = 0;

				do {
				    try {
				        System.out.println("--- Menu do Gerenciamento de Coworking ---");
				        System.out.println("1 - Cadastrar espaço");
				        System.out.println("2 - Reservar espaço");
				        System.out.println("3 - Cancelar reserva");
				        System.out.println("4 - Registros de pagamento");
				        System.out.println("5 - Exibição de relatório");
				        System.out.println("6 - Sair");
				        System.out.print("Escolha a opção pelo número: ");

				        menu = in.nextInt();
				        in.nextLine(); 

				        if (menu < 1 || menu > 6) {
				            System.out.println("Opção inválida! Digite um número entre 1 e 6.\n");
				        }

				    } catch (Exception e) {
				        System.out.println("Entrada inválida! Digite apenas números.\n");
				        in.nextLine();
				    }
				    switch (menu) {
	                case 1:
	                    CadastroEspacoView.MostrarCadastro();
	                    break;
	                case 2:
	                    ReservaEspacoView.MenuReserva();
	                    break;
	                case 3:
	                    CancelarReservaView.Cancelar();
	                    break;
	                case 4:
	                    ;
	                    break;
	                case 5:
	                	RelatoriosView.MenuRelatorios();
	                    break;
	                case 6:
	                    System.out.println("Encerrando...");
	                    break;
				    }
				} while (menu != 6);
	}				
}
