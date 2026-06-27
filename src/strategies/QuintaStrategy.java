package src.strategies;

import src.interfaces.IDiaStrategy;

public class QuintaStrategy implements IDiaStrategy {

    @Override
    public String getPrioridade() {
        return "MÉDIA";
    }

    @Override
    public void executar(String nome, String tarefa) {
        System.out.println("Usuário: " + nome);
        System.out.println("Dia consultado: quinta-feira");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: " + nome + ", que tal colaborar com alguém da equipe hoje? A tarefa \"" + tarefa + "\" pode ser uma boa oportunidade.");
    }
}
