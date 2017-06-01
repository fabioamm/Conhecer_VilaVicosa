package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ReservedArea extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserved_area);
        getSupportActionBar().setTitle("Área reservada");

        findViews();

        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uAdmin = etUsername.getText().toString();
                String pAdmin = etPassword.getText().toString();

                if (uAdmin.equals("admin") && (pAdmin.equals("admin"))) {
                    Intent intent = new Intent(ReservedArea.this, ReservedAreaMenu.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Insira credencias válidas", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }

    private void findViews() {
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
    }
}
