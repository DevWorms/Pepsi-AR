package com.developers.devworms.daimler_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegistroExito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_exito);
    }

    public void validarRegistro(View view){
        Intent registrarScreen = new Intent(this, MenuPepsico.class);
        startActivity(registrarScreen);
    }

}

