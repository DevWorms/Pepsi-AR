package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Rally extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rally);
    }

    public void rallyCode(){
        Intent i = new Intent(this, RallyCode.class);
        startActivity(i);
    }

    public void pistaUno(View v){
        rallyCode();
    }

    public void pistaDos(View v){
        rallyCode();
    }

    public void pistaTres(View v){
        rallyCode();
    }

    public void pistaCuatro(View v){
        rallyCode();
    }

    public void pistaCinco(View v){
        rallyCode();
    }

    public void pistaSeis(View v){
        rallyCode();
    }

    public void pistaSiete(View v){
        rallyCode();
    }

    public void pistaOcho(View v){
        rallyCode();
    }

    public void pistaNueve(View v){
        rallyCode();
    }
}
