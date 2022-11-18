package com.example.trabalhofinal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
                "id INTEGER PRIMARY KEY," +
                "fabricante TEXT NOT NULL," +
                "preco REAL NOT NULL," +
                "modelo TEXT NOT NULL," +
                "tipoVeiculo TEXT NOT NULL)";

        sqLiteDatabase.execSQL(sql);

        String sql1 = "insert into carro values (null, 'GM', 81.580, 'Onix', 'Hatch')," +
                "(null, 'VW', 113.880, 'Virtus', 'Sedan')," +
                "(null, 'Honda', 184.500, 'HR-V', 'SUV')," +
                "(null, 'GM', 106.560, 'Spin', 'Minivan')," +
                "(null, 'FIAT', 106.690, 'Fiorino', 'Furgão_pequeno')," +
                "(null, 'Toyota', 290.690, 'Hilux', 'Caminhonete_media')," +
                "(null, 'FIAT', 127.890, 'Strada', 'Caminhonete_pequena')";

        sqLiteDatabase.execSQL(sql1);
        Log.i("carro","Executado onCreate");
    }
    public List<Carro> buscaTodosCarros(){
        List<Carro> listaCarro = new ArrayList<>();
        String sql = "select fabricante, preco, modelo,tipoVeiculo from carro";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        for(int i=0; i < cursor.getCount(); i++){
            Carro carro = new Carro();
            carro.setFabricante(cursor.getString(0));
            carro.setPreco(cursor.getFloat(1));
            carro.setModelo(cursor.getString(2));
            carro.setTipoVeiculo(cursor.getString(3));
            listaCarro.add(carro);
            cursor.moveToNext();
        }
        cursor.close();
        return listaCarro;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("carro","Executado onUpgrade");
    }
}