package View;

import java.util.Scanner;
import Service.PagamentoService;

public class PagamentoView {
    private static PagamentoService pagamentoService = new PagamentoService();
    private static Scanner in = new Scanner(System.in);

    public static void realizarPagamento() {
        System.out.println("\n--- Registro de Pagamento ---");
        
        System.out.print("Digite o ID da Reserva a pagar: ");
        int idReserva = -1;
        try {
            idReserva = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("ID inválido.");
            return;
        }


        System.out.println("Métodos disponíveis: Pix, Cartão, Dinheiro");
        System.out.print("Informe o método de pagamento: ");
        String metodo = in.nextLine();

        try {
            pagamentoService.registrarPagamento(idReserva, metodo);
            System.out.println("Pagamento registrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado ao registrar pagamento.");
            e.printStackTrace();
        }
    }
}