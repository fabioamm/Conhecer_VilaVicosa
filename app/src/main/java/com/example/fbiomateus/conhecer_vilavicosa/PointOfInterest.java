package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class PointOfInterest extends AppCompatActivity {

    private String type;
    DBHelper dbHelper;
    private ListView listPlaces;
    ArrayList<Place> places = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_poi);
        dbHelper = new DBHelper(this);


        //Get buttons type
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            type = (String) bundle.get("type");
        }
        getSupportActionBar().setTitle(type);

        listPlaces = (ListView) findViewById(R.id.listPoint);

        listPlaces.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PointOfInterest.this, Description.class);
                intent.putExtra("id", places.get(position).getId());
                intent.putExtra("name", places.get(position).getName());
                intent.putExtra("description", places.get(position).getDescription());
                intent.putExtra("openHour", places.get(position).getOpenHour());
                intent.putExtra("closeHour", places.get(position).getCloseHour());
                intent.putExtra("contact", places.get(position).getContact());
                intent.putExtra("imgUrl", places.get(position).getImgUrl());
                intent.putExtra("latitude", places.get(position).getLatitude());
                intent.putExtra("longitude", places.get(position).getLongitude());
                startActivity(intent);
            }
        });
       listPlaces(type);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        listPlaces(type);
    }

    public void listPlaces(String type){
        places = dbHelper.getPlacesbyType(type);
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
    }
}