package View;

import java.util.Scanner;
import Service.CancelamentoService;
import Service.ReservaService;
import Model.Reserva;

public class CancelarReservaView {
    private static Scanner in = new Scanner(System.in);
    private static CancelamentoService cancelamentoService = new CancelamentoService();
    private static ReservaService reservaService = new ReservaService();

    public static void Cancelar() {
        int idReserva = -1;

        System.out.println("\n--- Cancelar Reserva ---");

        while (true) {
            System.out.print("Digite o ID da reserva que deseja cancelar: ");
            try {
                idReserva = Integer.parseInt(in.nextLine());

                if (idReserva > 0) {
                    break;
                } else {
                    System.out.println("Erro: o ID deve ser um número positivo");
                }

            } catch (Exception e) {
                System.out.println("Erro: digite apenas números inteiros");
            }
        }

        Reserva reservaEncontrada = reservaService.buscarPorId(idReserva);

        if (reservaEncontrada == null) {
            System.out.println("Erro: Nenhuma reserva encontrada com o ID " + idReserva);
            return; 
        }
        

        System.out.println("Reserva localizada: " + reservaEncontrada.getEspaco().getNome() + 
                           " | Data: " + reservaEncontrada.getInicio());

        while (true) {
            System.out.print("\nTem certeza que deseja cancelar (Sim/Não)? ");
            String certeza = in.nextLine().trim();

            if (certeza.equalsIgnoreCase("sim")) {
                

                String mensagemResultado = cancelamentoService.cancelarReserva(idReserva);
                
                System.out.println("\n" + mensagemResultado);
                break;

            } else if (certeza.equalsIgnoreCase("não") || certeza.equalsIgnoreCase("nao")) {
                System.out.println("\nA reserva não foi cancelada");
                break;
            } else {
                System.out.println("Erro: responda apenas com 'Sim' ou 'Não'");
            }
        }
    }
}