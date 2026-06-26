package src.strategies;

import src.interfaces.IDiaStrategy;

public class SextaStrategy implements IDiaStrategy {

    @Override
    public String getPrioridade() {
        return "BAIXA";
    }

    @Override
    public void executar(String nome, String tarefa) {
        System.out.println("Usuário: " + nome);
        System.out.println("Dia consultado: sexta-feira");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: Quase lá, " + nome + "! Registre o que foi concluído, incluindo o progresso em \"" + tarefa + "\".");
    }
}
