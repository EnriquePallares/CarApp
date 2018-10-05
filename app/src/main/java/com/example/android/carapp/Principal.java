package com.example.android.carapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    private Intent i;
    private RecyclerView lstOpciones;
    private ArrayList<Carro> carros;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstOpciones = findViewById(R.id.lstCarros);
        carros = Datos.obtener();

        AdaptadorCarro adaptadorCarros = new AdaptadorCarro(carros, this);

        llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adaptadorCarros);
    }

    public void agregarCarros(View v) {
        i = new Intent(Principal.this, AgregarCarros.class);
        startActivity(i);
        finish();
    }
}
