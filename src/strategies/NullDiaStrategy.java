package src.strategies;

import src.interfaces.IDiaStrategy;

public class NullDiaStrategy implements IDiaStrategy {

    @Override
    public String getPrioridade() {
        return "N/A";
    }

    @Override
    public void executar(String nome, String tarefa) {
        System.out.println("Dia inválido ou sem estratégia associada. Nenhuma ação foi executada.");
    }
}
