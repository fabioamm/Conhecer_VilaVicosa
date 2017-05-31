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

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_db);

        dbHelper = new DBHelper(this);

        dbHelper.insertPlace("Accomodation", "LOL", "XD", "12:00", "19:00", "222 222 222", "asd");
    }

}
