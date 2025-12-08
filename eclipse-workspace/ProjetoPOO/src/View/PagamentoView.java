package View;

import java.util.Scanner;
import Service.PagamentoService;

public class PagamentoView {
    private static PagamentoService pagamentoService = new PagamentoService();
    private static Scanner in = new Scanner(System.in);

    public static void realizarPagamento() {
        System.out.println("\n--- Registro de Pagamento ---");
        
        int tipoReserva = 0;
        while (true) {
            try {
                System.out.println("Qual tipo de reserva deseja pagar?");
                System.out.println("1 - Cabine Individual");
                System.out.println("2 - Auditório");
                System.out.println("3 - Sala de Reunião");
                System.out.print("Escolha: ");
                
                tipoReserva = Integer.parseInt(in.nextLine());
                
                if (tipoReserva >= 1 && tipoReserva <= 3) {
                    break;
                } else {
                    System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida! Digite apenas números.");
            }
        }

        System.out.print("\nDigite o ID da Reserva a pagar: ");
        int idReserva = -1;
        try {
            idReserva = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido");
            return;
        }

        System.out.println("\nMétodos disponíveis: Pix, Cartão, Dinheiro");
        System.out.print("Informe o método de pagamento: ");
        String metodo = in.nextLine();

        try {
            switch (tipoReserva) {
                case 1:
                    pagamentoService.registrarPagamentoCabine(idReserva, metodo);
                    break;
                case 2:
                    pagamentoService.registrarPagamentoAuditorio(idReserva, metodo);
                    break;
                case 3:
                    pagamentoService.registrarPagamentoSalaDeReuniao(idReserva, metodo);
                    break;
            }
            System.out.println("Pagamento registrado");
            
        } catch (IllegalArgumentException e) {
            System.out.println( e.getMessage());
        } catch (Exception e) {
            System.out.println("\nErro inesperado ao registrar pagamento.");
            e.printStackTrace();
        }
    }
}