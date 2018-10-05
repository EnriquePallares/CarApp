package com.example.android.carapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class AgregarCarros extends AppCompatActivity {

    private EditText txtPlaca, txtPrecio;
    private Spinner cmbColores, cmbMarcas;
    private ImageView foto;
    private ArrayList<Integer> fotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_carros);

        txtPlaca = findViewById(R.id.txtPlaca);
        txtPrecio = findViewById(R.id.txtPrecio);
        cmbMarcas = findViewById(R.id.cmbMarcas);
        cmbColores = findViewById(R.id.cmbColores);
        foto = findViewById(R.id.foto);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
        fotos.add(R.drawable.images4);
        fotos.add(R.drawable.images5);
    }

    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());

        return fotos.get(fotoSeleccionada);
    }

    public void guardar(View v){
        String placa;
        int foto, marcas, colores, precio;
        if (validar()) {
            foto = this.fotoAleatoria();
            placa = txtPlaca.getText().toString();
            precio = Integer.parseInt(txtPrecio.getText().toString());
            marcas = cmbMarcas.getSelectedItemPosition();
            colores = cmbColores.getSelectedItemPosition();

            Carro c = new Carro(foto, placa, colores, marcas, precio);
            c.guardar();
            limpiar();

            Snackbar.make(v, getResources().getString(R.string.guardado_exitoso), Snackbar.LENGTH_SHORT).show();
        }
    }

    public boolean validar(){
        int marcas = cmbMarcas.getSelectedItemPosition();
        int colores = cmbColores.getSelectedItemPosition();

        if (txtPlaca.getText().toString().isEmpty()){
            txtPlaca.setError(getResources().getString(R.string.err_vacio));
            txtPlaca.requestFocus();
            return false;
        }
        if (txtPrecio.getText().toString().isEmpty()){
            txtPrecio.setError(getResources().getString(R.string.err_vacio));
            txtPrecio.requestFocus();
            return false;
        }
        if (Integer.parseInt(txtPrecio.getText().toString()) == 0){
            txtPrecio.setError(getResources().getString(R.string.err_cero));
            txtPrecio.requestFocus();
            return false;
        }
        if (colores == 0){
            Toast.makeText(this, getResources().getString(R.string.err_colores), Toast.LENGTH_SHORT).show();
            return false;
        }
        if (marcas == 0){
            Toast.makeText(this, getResources().getString(R.string.err_marcas), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void limpiar(){
        txtPlaca.setText("");
        txtPrecio.setText("");
        cmbColores.setSelection(0);
        cmbMarcas.setSelection(0);
        txtPlaca.requestFocus();

        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarCarros.this, Principal.class);
        startActivity(i);
    }

    public void limpiar(View v){
        limpiar();
    }
}
