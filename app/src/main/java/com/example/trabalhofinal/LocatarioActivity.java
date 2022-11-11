package com.example.trabalhofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LocatarioActivity extends AppCompatActivity {

    BancoDeDadosActivity bancoDeDados =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locatario);

        bancoDeDados = new BancoDeDadosActivity(this);
    }

}