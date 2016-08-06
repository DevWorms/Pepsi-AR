package com.developers.devworms.daimler_android;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    // Progress Dialog
    private ProgressDialog pDialog;

    //  Datos Usuario
    EditText mail;
    EditText contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mail = (EditText)findViewById(R.id.mailText);
        contrasena = (EditText)findViewById(R.id.passText);

    }

    public void pantallaRegistro(View view) {
        Intent llamarScreenCodigo = new Intent(this, MainActivity.class);
       // Intent llamarScreenCodigo = new Intent(this, agendaActivity.class);
        startActivity(llamarScreenCodigo);
    }

    public void moduloRegistro (View view){
                new LoadAlbums().execute();

    }


    class LoadAlbums extends AsyncTask<String, String, String> {

        String mailStr = mail.getText().toString();
        String passStr = contrasena.getText().toString();
        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(LoginActivity.this);
            pDialog.setMessage("Ingresando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        /**
         * getting Albums JSON
         * */
        protected String doInBackground(String... args) {
            // Building Parameters
            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType, "correo=" + mailStr + "&passw=" + passStr);
            Request request = new Request.Builder()
                    .url("http://app-pepsico.palindromo.com.mx/APP/userLogin.php")
                    .post(body)
                    .build();

            try {
                Response response = client.newCall(request).execute();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all albums

            pDialog.dismiss();

            Context context = getApplicationContext();
            CharSequence text = "0";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }
}
