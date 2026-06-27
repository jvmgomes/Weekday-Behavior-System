package src.strategies;

import src.interfaces.IDiaStrategy;

public class SabadoStrategy implements IDiaStrategy {

    @Override
    public String getPrioridade() {
        return "BAIXA";
    }

    @Override
    public void executar(String nome, String tarefa) {
        System.out.println("Usuário: " + nome);
        System.out.println("Dia consultado: sábado");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: " + nome + ", aproveite o sábado para um estudo livre ou descanso. Se quiser, avance um pouco em \"" + tarefa + "\".");
    }
}
