package com.example.trabalhofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LocatarioLocadorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locatario_locador);
    }

    public void locatario(View view) {
        Intent intent = new Intent(this, LocatarioActivity.class);
        startActivity(intent);
    }

    public void locador(View view) {

        Intent intent = new Intent(this, LocadorActivity.class);
        startActivity(intent);
    }
}