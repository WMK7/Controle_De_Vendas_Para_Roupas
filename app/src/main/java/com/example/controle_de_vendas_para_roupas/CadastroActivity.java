package com.example.controle_de_vendas_para_roupas;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.controle_de_vendas_para_roupas.databinding.ActivityCadastroBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastroActivity extends AppCompatActivity {

    private ActivityCadastroBinding binding;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        databaseReference = FirebaseDatabase.getInstance().getReference("pedidos");

        // Configurar spinners
        ArrayAdapter<CharSequence> corAdapter = ArrayAdapter.createFromResource(this,
                R.array.cores_array, android.R.layout.simple_spinner_item);
        corAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerCor.setAdapter(corAdapter);

        ArrayAdapter<CharSequence> tamanhoAdapter = ArrayAdapter.createFromResource(this,
                R.array.tamanhos_array, android.R.layout.simple_spinner_item);
        tamanhoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerTamanho.setAdapter(tamanhoAdapter);

        ArrayAdapter<CharSequence> situacaoAdapter = ArrayAdapter.createFromResource(this,
                R.array.situacao_pagamento_array, android.R.layout.simple_spinner_item);
        situacaoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinnerSituacao.setAdapter(situacaoAdapter);

        binding.btnSalvar.setOnClickListener(v -> salvarPedido());

        binding.btnVoltar.setOnClickListener(v -> finish());
    }

    private void salvarPedido() {
        String codigo = binding.etCodigo.getText().toString();
        String nome = binding.etNome.getText().toString();
        String cor = binding.spinnerCor.getSelectedItem().toString();
        String tamanho = binding.spinnerTamanho.getSelectedItem().toString();
        String quantidade = binding.etQuantidade.getText().toString();
        String nomeCliente = binding.etNomeCliente.getText().toString();
        String telefone = binding.etTelefone.getText().toString();
        String situacao = binding.spinnerSituacao.getSelectedItem().toString();

        Pedido pedido = new Pedido(codigo, nome, cor, tamanho, quantidade, nomeCliente, telefone, situacao);
        databaseReference.push().setValue(pedido);

        // Exibir Toast na parte superior
        Toast toast = Toast.makeText(getApplicationContext(), "Pedido cadastrado com sucesso!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

        // Limpar campos
        limparCampos();
    }

    private void limparCampos() {
        binding.etCodigo.setText("");
        binding.etNome.setText("");
    }
}

