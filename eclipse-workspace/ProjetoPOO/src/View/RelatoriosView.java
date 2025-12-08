package View;

import Service.ReservaService;
import Model.Reserva;
import Model.CabineIndividual;
import Model.Auditorio;
import Model.SalaDeReuniao;
import Model.Espaco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class RelatoriosView {

    private static ReservaService reservaService = new ReservaService();
    private static Scanner in = new Scanner(System.in);
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void MenuRelatorios() {
        int opcao = 0;
        do {
            System.out.println("\n--- Menu de Relatórios ---");
            System.out.println("1 - Reservas realizadas em um período");
            System.out.println("2 - Faturamento por tipo de espaço");
            System.out.println("3 - Utilização por espaço (Total de horas)");
            System.out.println("4 - Top espaços mais utilizados");
            System.out.println("5 - Voltar");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(in.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                continue;
            }

            switch (opcao) {
                case 1:
                    relatorioReservasPorPeriodo();
                    break;
                case 2:
                    relatorioFaturamentoPorTipo();
                    break;
                case 3:
                    relatorioUtilizacaoPorEspaco();
                    break;
                case 4:
                    relatorioTopEspacos();
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void relatorioReservasPorPeriodo() {
        System.out.println("\n--- Relatório: Reservas por Período ---");
        try {
            System.out.print("Digite a data de início (dd/MM/yyyy HH:mm): ");
            String inicioStr = in.nextLine();
            LocalDateTime inicio = LocalDateTime.parse(inicioStr, format);

            System.out.print("Digite a data de fim (dd/MM/yyyy HH:mm): ");
            String fimStr = in.nextLine();
            LocalDateTime fim = LocalDateTime.parse(fimStr, format);

            List<Reserva> todasReservas = reservaService.listar();
            boolean encontrou = false;

            System.out.printf("%-5s | %-20s | %-20s | %-10s\n", "ID", "Espaço", "Data Início", "Valor");
            System.out.println("------------------------------------------------------------------");

            for (Reserva r : todasReservas) {
                if (!r.isCancelada() &&
                    (r.getInicio().isEqual(inicio) || r.getInicio().isAfter(inicio)) &&
                    (r.getFim().isEqual(fim) || r.getFim().isBefore(fim))) {
                    
                    System.out.printf("%-5d | %-20s | %-20s | R$ %.2f\n",
                            r.getId(),
                            r.getEspaco().getNome(),
                            r.getInicio().format(format),
                            r.getValorCalculado());
                    encontrou = true;
                }
            }

            if (!encontrou) {
                System.out.println("Nenhuma reserva encontrada neste período.");
            }

        } catch (Exception e) {
            System.out.println("Erro ao processar datas. Certifique-se de usar o formato dd/MM/yyyy HH:mm");
        }
    }

    private static void relatorioFaturamentoPorTipo() {
        System.out.println("\n--- Relatório: Faturamento por Tipo ---");
        double totalCabine = 0;
        double totalAuditorio = 0;
        double totalSala = 0;

        List<Reserva> lista = reservaService.listar();

        for (Reserva r : lista) {
            if (!r.isCancelada()) {
                Espaco e = r.getEspaco();
                if (e instanceof CabineIndividual) {
                    totalCabine += r.getValorCalculado();
                } else if (e instanceof Auditorio) {
                    totalAuditorio += r.getValorCalculado();
                } else if (e instanceof SalaDeReuniao) {
                    totalSala += r.getValorCalculado();
                }
            }
        }

        System.out.printf("Cabine Individual: R$ %.2f\n", totalCabine);
        System.out.printf("Auditório:         R$ %.2f\n", totalAuditorio);
        System.out.printf("Sala de Reunião:   R$ %.2f\n", totalSala);
        System.out.println("-----------------------------");
        System.out.printf("TOTAL GERAL:       R$ %.2f\n", (totalCabine + totalAuditorio + totalSala));
    }

    private static void relatorioUtilizacaoPorEspaco() {
        System.out.println("\n--- Relatório: Utilização por Espaço ---");
        Map<String, Long> utilizacao = calcularUtilizacao();

        if (utilizacao.isEmpty()) {
            System.out.println("Nenhuma reserva registrada.");
            return;
        }

        System.out.printf("%-20s | %s\n", "Nome do Espaço", "Horas Reservadas");
        System.out.println("---------------------------------------");
        
        for (Map.Entry<String, Long> entry : utilizacao.entrySet()) {
            System.out.printf("%-20s | %d horas\n", entry.getKey(), entry.getValue());
        }
    }

    private static void relatorioTopEspacos() {
        System.out.println("\n--- Relatório: Top Espaços Mais Utilizados ---");
        Map<String, Long> utilizacao = calcularUtilizacao();

        if (utilizacao.isEmpty()) {
            System.out.println("Nenhuma reserva registrada.");
            return;
        }

        utilizacao.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3) 
                .forEach(entry -> {
                    System.out.printf("Espaço: %-15s - Total: %d horas\n", entry.getKey(), entry.getValue());
                });
    }


    private static Map<String, Long> calcularUtilizacao() {
        Map<String, Long> mapaUtilizacao = new HashMap<>();
        List<Reserva> lista = reservaService.listar();

        for (Reserva r : lista) {
            if (!r.isCancelada()) {
                String nomeEspaco = r.getEspaco().getNome();
                long horas = r.getDuracaoEmHoras();


                mapaUtilizacao.put(nomeEspaco, mapaUtilizacao.getOrDefault(nomeEspaco, 0L) + horas);
            }
        }
        return mapaUtilizacao;
    }
}