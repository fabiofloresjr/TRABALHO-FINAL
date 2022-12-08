package com.example.trabalhofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

public class VendedorActivity extends AppCompatActivity {

    BancoDeDadosActivity bancoDadosJogo = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bancoDadosJogo = new BancoDeDadosActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendedor);

    }

    public void salvarCarro(View view) {
        EditText fabricante =findViewById(R.id.editTextFabricante);
        EditText preco =findViewById(R.id.editTextPreco);
        EditText modelo =findViewById(R.id.editTextModelo);
        EditText tipo =findViewById(R.id.editTextFabricante);

        Carro carro = new Carro();
        carro.setFabricante(fabricante.getText().toString());
        carro.setModelo(preco.getText().toString());
        Float precoFloat = Float.parseFloat(preco.getText().toString());
        carro.setPreco(precoFloat);
        carro.setModelo(modelo.getText().toString());
        carro.setTipoVeiculo(tipo.getText().toString());

        bancoDadosJogo.salvarCarro(carro);

        Intent intent = new Intent(this, ListagemCarrosActivity.class);
        startActivity(intent);
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDadosJogo.buscaTodosCarros());

        Intent intent1 = new Intent(this, ListagemCarrosActivity.class);
        intent.putExtras(bundle);
        startActivity(intent1);
    }
}