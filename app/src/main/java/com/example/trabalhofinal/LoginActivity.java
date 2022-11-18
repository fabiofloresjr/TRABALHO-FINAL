package com.example.trabalhofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    BancoDeDadosActivity bancoDeDadosActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bancoDeDadosActivity = new BancoDeDadosActivity(this);
    }

    public void login(View view) {
        EditText nome =findViewById(R.id.editTextTextNome);
        Switch simpleSwitch = (Switch) findViewById(R.id.switch1);
        Boolean switchState = simpleSwitch.isChecked();

        if(nome.getText().toString().equals("")){
            Toast.makeText(this,"ERROR, Nome está vazio.",Toast.LENGTH_LONG).show();
            return;
        }
        if (switchState) {
            Intent intent = new Intent(this, CompradorVendedorActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"ERROR, Não tem idade suficiente.",Toast.LENGTH_LONG).show();
        }

    }
}