package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReservedArea extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private TextView tu;
    private TextView tp;
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
                if ((etUsername.getText().toString() == "admin") && (etPassword.getText().toString() == "admin")) {
                    Intent intent = new Intent(ReservedArea.this, AddPlace.class);
                    startActivity(intent);
                } else {
                    tu.setText("NAO DEU");
                    //tp.setText(etPassword.getText());
                }
            }
        });
    }

    private void findViews() {
        this.etUsername = (EditText) findViewById(R.id.etUsername);
        this.etPassword = (EditText) findViewById(R.id.etPassword);
        this.tu = (TextView) findViewById(R.id.textView);
        this.tp = (TextView) findViewById(R.id.textView2);
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
    }
}
