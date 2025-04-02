package com.example.gerenciadordetarefas;

public class TarefaImportante implements Tarefa{
    private String descricao;
    private String prazo;

    public TarefaImportante(String descricao, String prazo) {
        this.descricao = descricao;
        this.prazo = prazo;
    }

    public String getDescricao() {
        return "Descrição: " + descricao + "\nPrazo: " + prazo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPrazo() {
        return prazo;
    }

    public void setPrazo(String prazo) {
        this.prazo = prazo;
    }
}
