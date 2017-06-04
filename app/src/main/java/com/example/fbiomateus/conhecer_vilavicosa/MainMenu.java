package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Intent;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {

    float x1,x2;
    float y1, y2;
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
                intent.putExtra("type","Monumentos");
                startActivity(intent);
            }
        });

        btnRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PointOfInterest.class);
                intent.putExtra("type","Restaurantes");
                startActivity(intent);
            }
        });

        btnAcomoddation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PointOfInterest.class);
                intent.putExtra("type","Alojamento");
                startActivity(intent);
            }
        });

        btnEntretainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),PointOfInterest.class);
                intent.putExtra("type","Entretenimento");
                startActivity(intent);
            }
        });
    }

    public boolean onTouchEvent(MotionEvent touchevent)
    {
        switch (touchevent.getAction())
        {
            // when user first touches the screen we get x and y coordinate
            case MotionEvent.ACTION_DOWN:
            {
                x1 = touchevent.getX();
                y1 = touchevent.getY();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                x2 = touchevent.getX();
                y2 = touchevent.getY();

                //if left to right sweep event on screen
                if (x1 < x2)
                {
                    Intent intent = new Intent(getApplicationContext(), ReservedArea.class);
                    startActivity(intent);
                }
                break;
            }
        }
        return false;
    }
}
