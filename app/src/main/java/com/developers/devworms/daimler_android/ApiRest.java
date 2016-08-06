package com.developers.devworms.daimler_android;


import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sergio on 29/05/16.
 */
public class ApiRest {

    public static List<PdfPojo> consultarListadoPdf(){

        List<PdfPojo> lPdf = new ArrayList<PdfPojo>();

        try {
            // TODO code application logic here

            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/octet-stream");
            Request request = new Request.Builder()
                    .url("http://app-ecodsa.com.mx/daimler/presentacion.php")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b983b2f6-8cd7-5956-32f5-bc7cf4e53b9f")
                    .build();
            JSONArray values = new RequestApi().execute(request).get();

            for (int i = 0; i < values.length(); i++) {

                JSONObject sensorApi = values.getJSONObject(i);
                PdfPojo pdfPojo = new PdfPojo();
                pdfPojo.setId_presentacion(sensorApi.getString("id"));
                pdfPojo.setNombre(sensorApi.getString("nombre"));
                pdfPojo.setLink_presentacion(sensorApi.getString("link_presentacion"));
                lPdf.add(pdfPojo);
            }
        }
        catch (Exception ex){

        }

        return lPdf;
    }

    public static List<menuPojo> consultarListadoMenu(String dia) {

        List<menuPojo> lMenu = new ArrayList<menuPojo>();

        try {
            Log.d("RestApi","respuesta  consulta");
            // TODO code application logic here

            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/octet-stream");
            Request request = new Request.Builder()
                    .url("http://app-pepsico.palindromo.com.mx/APP/"+dia+".php")
                    .get()
                    .build();
            JSONArray values = new RequestApi().execute(request).get();
            Log.d("RestApi","respuesta "+ values.length());
            for (int i = 0; i < values.length(); i++) {

                JSONObject sensorApi = values.getJSONObject(i);
                menuPojo menPojo = new menuPojo();
                Log.d("RestApi","respuesta "+sensorApi.getString("id"));
                menPojo.setId(sensorApi.getString("id"));
                Log.d("RestApi","respuesta "+sensorApi.getString("nombre"));
                menPojo.setNombre(sensorApi.getString("nombre"));
                Log.d("RestApi","respuesta "+sensorApi.getString("salon"));
                menPojo.setSalon(sensorApi.getString("salon"));
                Log.d("RestApi","respuesta "+sensorApi.getString("horario"));
                menPojo.setHorario(sensorApi.getString("horario"));
                Log.d("RestApi","respuesta "+sensorApi.getString("codigo"));
                menPojo.setCodigo(sensorApi.getString("codigo"));
                Log.d("RestApi","respuesta "+sensorApi.getString("img"));
               // menPojo.setRecomendaciones(sensorApi.getString("img"));
                Log.d("RestApi","respuesta "+sensorApi.getString("dia"));
                menPojo.setFecha(sensorApi.getString("dia"));
                lMenu.add(menPojo);
            }
        }
        catch (Exception ex){

        }

        return lMenu;
    }

    private static class RequestApi extends AsyncTask<Request, Void, JSONArray> {
        @Override
        protected JSONArray doInBackground(Request... params) {
            try {

                OkHttpClient client = new OkHttpClient();
                Response response = client.newCall(params[0]).execute();

                String string = response.body().string();
                JSONArray jsonObjects = new JSONArray(string);

                return jsonObjects;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }

    public static List<NotificacionPojo> consultarNotificaciones(){

        List<NotificacionPojo> lNotificaciones = new ArrayList<NotificacionPojo>();

        try {
            // TODO code application logic here

            OkHttpClient client = new OkHttpClient();

            MediaType mediaType = MediaType.parse("application/octet-stream");
            Request request = new Request.Builder()
                    .url("http://app-ecodsa.com.mx/daimler/avisos.php")
                    .get()
                    .addHeader("cache-control", "no-cache")
                    .addHeader("postman-token", "b983b2f6-8cd7-5956-32f5-bc7cf4e53b9f")
                    .build();
            JSONArray values = new RequestApi().execute(request).get();

            for (int i = 0; i < values.length(); i++) {

                JSONObject sensorApi = values.getJSONObject(i);
                NotificacionPojo notificacionPojo = new NotificacionPojo();
                notificacionPojo.setId(sensorApi.getString("id"));
                notificacionPojo.setNombre(sensorApi.getString("nombre"));
                notificacionPojo.setDescripcion(sensorApi.getString("descripcion"));
                lNotificaciones.add(notificacionPojo);
            }
        }
        catch (Exception ex){

        }

        return lNotificaciones;
    }


}
