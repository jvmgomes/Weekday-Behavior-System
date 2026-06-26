package src.strategies;

import src.interfaces.IDiaStrategy;

public class SegundaStrategy implements IDiaStrategy {

    @Override
    public String getPrioridade() {
        return "ALTA";
    }

    @Override
    public void executar(String nome, String tarefa) {
        System.out.println("Usuário: " + nome);
        System.out.println("Dia consultado: segunda-feira");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Início de semana, " + nome + "! Organize suas prioridades e coloque em dia a tarefa \"" + tarefa + "\".");
    }
}
