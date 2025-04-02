package com.example.gerenciadordetarefas;

public class TarefaSimples implements Tarefa {
    private String descricao;

    public TarefaSimples(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return "Descrição: " + descricao + "\nPrazo: ";
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
