package com.example.gerenciadordetarefas;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LinearLayout list;

    private EditText inputTask, inputTime;

    private Button button;

    private List<Tarefa> listTarefas = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.linearList);
        inputTask = findViewById(R.id.editTextText2);
        inputTime = findViewById(R.id.editTextText3);
        button = findViewById(R.id.button);

        button.setOnClickListener(view -> tarefa());
    }

    private void tarefa() {
        String descricao = inputTask.getText().toString().trim();
        String prazo = inputTime.getText().toString().trim();

        if (descricao.isEmpty()) {
            inputTask.setError("Tarefa obrigatória");
            return;
        }

        Tarefa novaTarefa;
        if (prazo.isEmpty()) {
            novaTarefa = new TarefaSimples(descricao);
        } else {
            novaTarefa = new TarefaImportante(descricao, prazo);
        }

        listTarefas.add(novaTarefa);

        CheckBox checkBox = new CheckBox(this);
        checkBox.setText(novaTarefa.getDescricao());
        checkBox.setTextSize(20);
        checkBox.setPadding(6, 10, 6, 10);

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                checkBox.setPaintFlags(checkBox.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

                checkBox.postDelayed(() -> {
                    list.removeView(checkBox);
                    listTarefas.remove(novaTarefa);
                }, 500);
            } else {
                checkBox.setPaintFlags(checkBox.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            }
        });

        list.addView(checkBox, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));

        inputTask.setText("");
        inputTime.setText("");
    }
}