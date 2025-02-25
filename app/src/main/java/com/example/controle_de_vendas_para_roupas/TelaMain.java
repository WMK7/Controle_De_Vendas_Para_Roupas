package com.example.controle_de_vendas_para_roupas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.controle_de_vendas_para_roupas.databinding.ActivityTelaMainBinding;

public class TelaMain extends Activity {
    private ActivityTelaMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCadastro.setOnClickListener(v -> {
            Intent intent = new Intent(TelaMain.this, CadastroActivity.class);
            startActivity(intent);
        });

        binding.btnVisualizar.setOnClickListener(v -> {
            Intent intent = new Intent(TelaMain.this, PedidosActivity.class);
            startActivity(intent);
        });
    }
}
