package com.example.android.carapp;

import java.util.ArrayList;

public class Datos {
    public static ArrayList<Carro> carros = new ArrayList();

    public static void agregar(Carro c){
        carros.add(c);
    }

    public static ArrayList<Carro> obtener(){
        return carros;
    }
}
