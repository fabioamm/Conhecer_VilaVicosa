package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button btnPatrimony, btnRestaurant, btnAcomoddation, btnEntretainment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btnPatrimony = (Button)findViewById(R.id.btnPatrimony);
        btnRestaurant = (Button)findViewById(R.id.btnRestaurant);
        btnAcomoddation = (Button)findViewById(R.id.btnAccomodation);
        btnEntretainment = (Button)findViewById(R.id.btnEntertainment);

        getSupportActionBar().setTitle("Menu inicial");

        btnPatrimony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PointOfInterest.class);
                intent.putExtra("id",0);
                startActivity(intent);
            }
        });

        btnRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PointOfInterest.class);
                intent.putExtra("id",1);
                startActivity(intent);
            }
        });

        btnAcomoddation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PointOfInterest.class);
                intent.putExtra("id",2);
                startActivity(intent);
            }
        });

        btnEntretainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PointOfInterest.class);
                intent.putExtra("id",3);
                startActivity(intent);
            }
        });



    }



    //ola isto e o commit motherfuck!
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_UP) :
                Intent intent = new Intent(getApplicationContext(), ReservedArea.class);
                startActivity(intent);
                return true;
            default :
                return super.onTouchEvent(event);
        }

    }
}
