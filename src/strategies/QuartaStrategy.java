package src.strategies;

import src.interfaces.IDiaStrategy;

public class QuartaStrategy implements IDiaStrategy {

    @Override
    public String getPrioridade() {
        return "MEDIA";
    }

    @Override
    public void executar(String nome, String tarefa) {
        System.out.println("Usuário: " + nome);
        System.out.println("Dia consultado: quarta-feira");
        System.out.println("Prioridade: " + getPrioridade());
        System.out.println("Mensagem: " + nome + ", dia de revisão: verifique o andamento de \"" + tarefa + "\".");
    }
}