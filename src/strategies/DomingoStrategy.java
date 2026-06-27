package src.strategies;

import src.interfaces.IDiaStrategy;

public class DomingoStrategy implements IDiaStrategy {

    @Override
    public String getPrioridade() {
        return "BAIXA";
    }

    @Override
    public void executar(String nome, String tarefa) {
        System.out.println("Usuário: " + nome);
        System.out.println("Dia consultado: domingo");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: " + nome + ", use o domingo para planejar a próxima semana. Não esqueça de incluir \"" + tarefa + "\" nos seus planos!");
    }
}
