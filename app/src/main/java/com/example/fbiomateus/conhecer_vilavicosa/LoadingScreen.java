package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class LoadingScreen extends AppCompatActivity {

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        getSupportActionBar().hide(); //Remover barra de titulo

        dbHelper = new DBHelper(this);


        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    if (dbHelper.getPlacebyName("Palacio Ducal").isEmpty()){
                        dbHelper.insertPlace("Monumentos", "Palacio Ducal", "Bla Bla", "12h", "13h", "234567890", null, "38.782500", "-7.421944");
                    }
                    else if (dbHelper.getPlacebyName("Restaurante Os Cucos").isEmpty()) {
                        dbHelper.insertPlace("Restaurantes", "Restaurante Os Cucos", "Bla Bla", "12h", "13h", "234567890", null, "38.776049", "-7.419009");
                    }else if (dbHelper.getPlacebyName("Alentejo Marmoris Hotel & Spa").isEmpty()){
                        dbHelper.insertPlace("Alojamento", "Alentejo Marmoris Hotel & Spa", "Bla Bla", "12h", "13h", "234567890", null, "38.777200", "-7.419980");
                    }else{
                        Log.d("Conhecer Vila Viçosa", "Default Points not working");
                    }
                    sleep(3000);
                    Intent intent = new Intent(getApplicationContext(), MainMenu.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
