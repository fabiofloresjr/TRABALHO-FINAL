package com.example.trabalhofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class BancoDeDadosActivity extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "carro";
    private static int VERSAO = 3;

    public BancoDeDadosActivity(Context context){
        super(context,NOME_BANCO,null,VERSAO);
        String name = getDatabaseName();
        Log.i("carros",name);

        getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Log.i("carros","Sendo executado onCreate");

        String sql = "CREATE TABLE carro (" +
                "id INTEGER PRIMARY KEY Autoincrement," +
                "fabricante TEXT NOT NULL," +
                "preco REAL NOT NULL," +
                "modelo TEXT NOT NULL," +
                "tipoVeiculo TEXT NOT NULL" +
                ")";

        sqLiteDatabase.execSQL(sql);

        Log.i("carro","Executado onCreate");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("carro","Executado onUpgrade");
    }
}