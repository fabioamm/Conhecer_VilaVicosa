package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReservedArea extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_area);
        getSupportActionBar().setTitle("Área reservada");

        username = (EditText) findViewById(R.id.txtName);
        password = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        /*this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((username.getText().toString() == "admin") & (password.getText().toString() == "admin")) {
                    Intent intent = new Intent(ReservedArea.this, AddPlace.class);
                    startActivity(intent);
                }
            }
        });*/
    }
}
