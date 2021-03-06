package com.developers.devworms.daimler_android;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class avisosActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avisos);


        final ArrayList<String> list = new ArrayList<String>();
        final ListView listview = (ListView) findViewById(R.id.listview);
        final List<NotificacionPojo> lNotificaciones = ApiRest.consultarNotificaciones();

        for(NotificacionPojo notificacion : lNotificaciones ){

            list.add(notificacion.getNombre());
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {

                Intent newScreen = new Intent(avisosActivity.this, notifActivity.class);
                newScreen.putExtra("mensaje", lNotificaciones.get(position).getDescripcion());
                startActivity(newScreen);
            }

        });


    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
            }
        }

        @Override
        public long getItemId(int position) {
            String item = getItem(position);
            return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }



    public void cumbreScreen(View view){
        Intent newScreen = new Intent(avisosActivity.this, menu.class);
        startActivity(newScreen);
    }

}
