package com.example.fbiomateus.conhecer_vilavicosa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TestMaps extends AppCompatActivity {
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_maps);

        dbHelper = new DBHelper(this);

        String name = dbHelper.getAllPlaces().get(0).getName();

        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}
