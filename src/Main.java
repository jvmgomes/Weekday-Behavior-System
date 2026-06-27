package src;

import java.util.Scanner;

import src.interfaces.IDiaStrategy;
import src.services.DiaStrategySelector;

public class Main {
    private static final String[] DIAS_VALIDOS = {
        "segunda-feira",
        "terça-feira",
        "quarta-feira",
        "quinta-feira",
        "sexta-feira",
        "sábado",
        "domingo"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DiaStrategySelector selector = new DiaStrategySelector();
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("=== Day Planner Menu ===");
            System.out.println("1 - Escolher um dia da lista");
            System.out.println("2 - Digitar um dia manualmente");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String option = scanner.nextLine().trim();

            switch (option) {
                case "1":
                    executarFluxoLista(scanner, selector);
                    break;
                case "2":
                    executarFluxoManual(scanner, selector);
                    break;
                case "0":
                    running = false;
                    System.out.println("Encerrando o Day Planner.");
                    continue;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }
        }

        scanner.close();
    }

    private static void executarFluxoLista(Scanner scanner, DiaStrategySelector selector) {
        String day = selecionarDiaDaLista(scanner);

        if (day == null) {
            return;
        }

        executarTarefa(scanner, selector, day);
    }

    private static void executarFluxoManual(Scanner scanner, DiaStrategySelector selector) {
        while (true) {
            System.out.print("Digite o dia da semana ou deixe em branco para usar a estratégia padrão: ");
            String day = scanner.nextLine().trim();

            if (day.isEmpty()) {
                System.out.println("Nenhum dia informado. A estratégia padrão será usada.");
                executarTarefa(scanner, selector, null);
                return;
            }

            if (isDiaValido(day)) {
                executarTarefa(scanner, selector, day);
                return;
            }

            System.out.println("Dia não reconhecido. A estratégia padrão (NullDiaStrategy) está disponível.");
            System.out.println("1 - Usar a estratégia padrão");
            System.out.println("2 - Digitar outro dia");
            System.out.println("0 - Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    executarTarefa(scanner, selector, null);
                    return;
                case "2":
                    continue;
                case "0":
                    return;
                default:
                    System.out.println("Opção inválida. Voltando ao menu principal.");
                    return;
            }
        }
    }

    private static String selecionarDiaDaLista(Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("Escolha um dia:");
            for (int i = 0; i < DIAS_VALIDOS.length; i++) {
                System.out.println((i + 1) + " - " + formatarDia(DIAS_VALIDOS[i]));
            }
            System.out.println("0 - Voltar");
            System.out.print("Opção: ");

            String option = scanner.nextLine().trim();

            if ("0".equals(option)) {
                return null;
            }

            try {
                int index = Integer.parseInt(option) - 1;
                if (index >= 0 && index < DIAS_VALIDOS.length) {
                    return DIAS_VALIDOS[index];
                }
            } catch (NumberFormatException ignored) {
            }

            System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void executarTarefa(Scanner scanner, DiaStrategySelector selector, String day) {
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Digite a tarefa do dia: ");
        String tarefa = scanner.nextLine().trim();

        IDiaStrategy strategy = selector.getStrategy(day);
        strategy.executar(nome, tarefa);
    }

    private static boolean isDiaValido(String day) {
        for (String diaValido : DIAS_VALIDOS) {
            if (diaValido.equalsIgnoreCase(day)) {
                return true;
            }
        }

        return false;
    }

    private static String formatarDia(String day) {
        return day.substring(0, 1).toUpperCase() + day.substring(1);
    }
}
