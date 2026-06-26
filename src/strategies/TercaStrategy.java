package src.strategies;

import src.interfaces.IDiaStrategy;

public class TercaStrategy implements IDiaStrategy {

    @Override
    public String getPrioridade() {
        return "ALTA";
    }

    @Override
    public void executar(String nome, String tarefa) {
        System.out.println("Usuário: " + nome);
        System.out.println("Dia consultado: terça-feira");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Avance nas tarefas pendentes, " + nome + "! Foque em concluir \"" + tarefa + "\".");
    }
}
