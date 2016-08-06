package com.developers.devworms.daimler_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class RegistroExito extends AppCompatActivity {

    //EditText campo;
    //int campo_validacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_exito);

        //campo = (EditText)findViewById(R.id.numValidText);

    }

    public void validarRegistro(View view){
        Context context = getApplicationContext();
        CharSequence text = "Bienvenido";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent registrarScreen = new Intent(this, MenuPepsico.class);
        startActivity(registrarScreen);

        }

    }

