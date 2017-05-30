package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class TestDB extends AppCompatActivity {

    private ListView listView;
    private DatabaseAccess databaseAccess;
    private List<Place> places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_db);
        this.listView = (ListView) findViewById(R.id.listView);
        this.databaseAccess = DatabaseAccess.getInstance(getApplicationContext());

        Button btnAdd = (Button) findViewById(R.id.button);

        //Set event listener to Button
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPlace();
            }
        });
    }

    /**
     * Read all the places
     *
     * @return List of places
     */
    private List<Place> getPlaces() {
        databaseAccess.open();
        List<Place> list = databaseAccess.getPlaces();
        databaseAccess.close();
        return list;
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateListView();
    }

    private void updateListView() {
        this.places = getPlaces();

        // Create the adapter and assign to ListView
        PlaceAdapter adapter = new PlaceAdapter(this, places);
        this.listView.setAdapter(adapter);
    }

    /**
     * Start ViewActivity to add new Place.
     */
    private void addPlace() {
        Intent intent = new Intent(this, AddPlace.class);
        startActivity(intent);
    }


    /**
     * Custom ArrayAdapter for Places.
     */
    private class PlaceAdapter extends ArrayAdapter<Place> {

        public PlaceAdapter(Context context, List<Place> objects) {
            super(context, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.list_item_layout, parent, false);
            }
            TextView tType = (TextView) convertView.findViewById(R.id.txtType);
            TextView tName = (TextView) convertView.findViewById(R.id.txtName);
            Place contact = places.get(position);
            tType.setText(contact.getType());
            tName.setText(contact.getName());
            return convertView;
        }
    }
}
