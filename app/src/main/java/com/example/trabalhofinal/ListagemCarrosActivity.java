package com.example.trabalhofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class ListagemCarrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_carros);

        List<Carro> listaCarro = (List<Carro>) getIntent().
                getSerializableExtra("lista");

        TextView textView = findViewById(R.id.textViewListagemCarros);

        StringBuilder mensagem = new StringBuilder();
        for(int i=0; i < listaCarro.size(); i++){
            Carro carro = listaCarro.get(i);
            mensagem.append("Id: ");
            mensagem.append(i);
            mensagem.append(" | ");
            mensagem.append("Fabricante: ");
            mensagem.append(carro.getFabricante());
            mensagem.append(" | ");
            mensagem.append("Modelo: ");
            mensagem.append(carro.getModelo());
            mensagem.append(" | ");
            mensagem.append("Tipo do Veículo: ");
            mensagem.append(carro.getTipoVeiculo());
            mensagem.append(" | ");
            mensagem.append("Custo: R$");
            mensagem.append(carro.getPreco());
            mensagem.append("\n");
            mensagem.append("------------------------------------------------------------------------------------------------------------");
            mensagem.append("\n");

        }
        textView.setText(mensagem.toString());
    }
}