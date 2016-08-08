package com.developers.devworms.daimler_android;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class RallyCode extends AppCompatActivity {

    // Progress Dialog
    private ProgressDialog pDialog;

    private String botonStr;
    private EditText editTextCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rally_code);

        botonStr = getIntent().getStringExtra("boton");
        editTextCode = (EditText)findViewById(R.id.editTextCode);
    }

    public void verificarCode(View v){

        Log.i("edit ",editTextCode.getText().toString());
        Log.i("boton ",botonStr);

        if (editTextCode.getText().toString().equals("camara")) {
            Log.i("entro1 ","entro1");
        }

        if (botonStr.equals("1") ) {
            Log.i("entro2 ","entro2");
        }

        if (botonStr.equals("1") && editTextCode.getText().toString().equals("camara")) {
            Log.i("entro3 ","entro3");
            new PostCode().execute();
            Log.i("entro32 ","entro32");
        }

    }

    class PostCode extends AsyncTask<String, String, String> {


        /**
         * Before starting background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(RallyCode.this);
            pDialog.setMessage("Validando...");
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
            RequestBody body = RequestBody.create(mediaType, "correo=" + "V" ); //--> cache mail
            Request request = new Request.Builder()
                    .url("http://app-pepsico.palindromo.com.mx/APP/respuestas.php")
                    .post(body)
                    .build();

            try {
                Response response = client.newCall(request).execute();

                /*if (response.isSuccessful()){
                    Intent registrarScreen = new Intent(RallyCode.this, RegistroExito.class);
                    startActivity(registrarScreen);
                }*/

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

            Intent registrarScreen = new Intent(RallyCode.this, Rally.class);
            startActivity(registrarScreen);
        }

    }
}
