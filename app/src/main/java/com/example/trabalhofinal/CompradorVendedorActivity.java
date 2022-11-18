package com.example.trabalhofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class CompradorVendedorActivity extends AppCompatActivity {

    BancoDeDadosActivity bancoDadosJogo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprador_vendedor);

        bancoDadosJogo = new BancoDeDadosActivity(this);
    }

    public void comprador(View view) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista", (Serializable) bancoDadosJogo.buscaTodosCarros());

        Intent intent= new Intent(this, CompradorActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void vendedor(View view) {

        Intent intent = new Intent(this, VendedorActivity.class);
        startActivity(intent);
    }
}