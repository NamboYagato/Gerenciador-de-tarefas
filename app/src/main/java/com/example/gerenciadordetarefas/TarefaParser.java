package com.example.gerenciadordetarefas;

import java.util.List;

public class TarefaParser {
    public static String mostrarTarefas(List<? extends Tarefa> list) {
        String descricao = "";
        for (Tarefa tarefa : list) {
            descricao += tarefa.getDescricao() + "\n";
        }
        return descricao;
    }
}
