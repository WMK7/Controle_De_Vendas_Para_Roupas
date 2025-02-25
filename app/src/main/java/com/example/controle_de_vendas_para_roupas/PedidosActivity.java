package com.example.controle_de_vendas_para_roupas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.controle_de_vendas_para_roupas.databinding.ActivityPedidosBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PedidosActivity extends AppCompatActivity {

    private ActivityPedidosBinding binding;
    private DatabaseReference databaseReference;
    private ListView listViewPedidos;
    private List<String> pedidosList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPedidosBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        databaseReference = FirebaseDatabase.getInstance().getReference("pedidos");
        listViewPedidos = binding.listViewPedidos;

        pedidosList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pedidosList);
        listViewPedidos.setAdapter(adapter);

        binding.btnVoltarVisualizar.setOnClickListener(v -> finish());

        carregarPedidos();
    }

    private void carregarPedidos() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                pedidosList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Pedido pedido = snapshot.getValue(Pedido.class);
                    if (pedido != null) {
                        String pedidoInfo = "Código: " + pedido.getCodigo() + "\n"
                                + "Nome: " + pedido.getNome() + "\n"
                                + "Cor: " + pedido.getCor() + "\n"
                                + "Tamanho: " + pedido.getTamanho() + "\n"
                                + "Quantidade: " + pedido.getQuantidade() + "\n"
                                + "Nome Cliente: " + pedido.getNomeCliente() + "\n"
                                + "Telefone: " + pedido.getTelefone() + "\n"
                                + "Situação: " + pedido.getSituacao();
                        pedidosList.add(pedidoInfo);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Tratar erro, se necessário
            }
        });
    }
}
