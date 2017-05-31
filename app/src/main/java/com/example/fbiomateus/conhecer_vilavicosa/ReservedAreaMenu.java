package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ReservedAreaMenu extends AppCompatActivity {

    DBHelper dbHelper;
    private Button btnAdd;
    private ListView listPlaces;
    ArrayList<Place> places = new ArrayList<>();
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_area_menu);
        getSupportActionBar().setTitle("Menu Administração");
        dbHelper = new DBHelper(this);

        /*this.btnUpdate = (Button) findViewById(R.id.btnUpdate);

        this.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(), "UPDATE", Toast.LENGTH_SHORT);
                toast.show();
            }
        });*/

        btnAdd = (Button) findViewById(R.id.btnAdd);
        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservedAreaMenu.this, AddPlace.class);
                startActivity(intent);
            }
        });

        listPlaces();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        listPlaces();
    }

    public void listPlaces(){
        places = dbHelper.getAllPlaces();
        this.listPlaces = (ListView) findViewById(R.id.listPlaces);

        PlaceAdapter adapter = new PlaceAdapter(getApplicationContext(), places);
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

           // ImageView icType = (ImageView) convertView.findViewById(R.id.icType);
            TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
            Place place = places.get(position);

            /*if(place.getType() == "Patrimony") {
                icType.setImageResource(R.drawable.ic_patrimony);
            } else if (place.getType() == "Accomodation") {
                icType.setImageResource(R.drawable.ic_accomodation);
            } else if (place.getType() == "Restaurant") {
                icType.setImageResource(R.drawable.ic_restaurant);
            } else if (place.getType() == "Entertainment") {
                icType.setImageResource(R.drawable.ic_entertainment);
            }*/

            txtName.setText(place.getName());

            return convertView;
        }
    }
}
