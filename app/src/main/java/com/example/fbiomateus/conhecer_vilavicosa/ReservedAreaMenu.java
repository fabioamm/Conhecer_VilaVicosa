package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReservedAreaMenu extends AppCompatActivity {

    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_area_menu);
        getSupportActionBar().setTitle("Menu Administração");

        btnAdd = (Button) findViewById(R.id.btnAdd);

        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReservedAreaMenu.this, AddPlace.class);
                startActivity(intent);
            }
        });
    }
}
