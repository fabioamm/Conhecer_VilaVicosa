package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.fbiomateus.conhecer_vilavicosa.R.id.listPlaces;

public class PointOfInterest extends AppCompatActivity {

    private int idButton;
    DBHelper dbHelper;
    private ListView listPlaces;
    ArrayList<Place> places = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_poi);

        //Get buttons id
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            idButton = (Integer) bundle.get("id");
        }
       // listPlaces();
    }

  /*  @Override
    protected void onPostResume() {
        super.onPostResume();
        listPlaces();
    }

    public void listPlaces(){
        places = dbHelper.getAllPlaces();
        this.listPlaces = (ListView) findViewById(R.id.listPoint);

        PointOfInterest.PlaceAdapter adapter = new PointOfInterest.PlaceAdapter(getApplicationContext(), places);
        listPlaces.setAdapter(adapter);
    }

    private class PlaceAdapter extends ArrayAdapter<Place> {


        public PlaceAdapter(Context context, List<Place> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_layout, parent, false);
            }

            TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
            Place place = places.get(position);

            txtName.setText(place.getName());

            return convertView;
        }
    }*/
}