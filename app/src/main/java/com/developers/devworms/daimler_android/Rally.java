package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Rally extends AppCompatActivity {

    private String boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rally);
    }

    public void rallyCode(String botonStr){
        Intent i = new Intent(this, RallyCode.class);
        i.putExtra("boton", botonStr);
        startActivity(i);
    }

    public void pistaUno(View v){
        rallyCode("1");
    }

    public void pistaDos(View v){
        rallyCode("2");
    }

    public void pistaTres(View v){
        rallyCode("3");
    }

    public void pistaCuatro(View v){
        rallyCode("4");
    }

    public void pistaCinco(View v){
        rallyCode("5");
    }

    public void pistaSeis(View v){
        rallyCode("6");
    }

    public void pistaSiete(View v){
        rallyCode("7");
    }

    public void pistaOcho(View v){
        rallyCode("8");
    }

    public void pistaNueve(View v){
        rallyCode("9");
    }
}
