package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddPlace extends AppCompatActivity {
    DBHelper dbHelper;
    private EditText etName;
    private EditText etDescription;
    private EditText etOpenHour;
    private EditText etCloseHour;
    private EditText etContact;
    private EditText etImgUrl;
    private EditText etLatitude;
    private EditText etLongitude;
    private Button btnAdd;
    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);
        getSupportActionBar().setTitle("Adicionar local");
        findViews();

        dbHelper = new DBHelper(this);

        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dbHelper.insertPlace(sp1.getSelectedItem().toString(), etName.getText().toString(), etDescription.getText().toString(), etOpenHour.getText().toString(), etCloseHour.getText().toString(), etContact.getText().toString(), etImgUrl.getText().toString(), etLatitude.getText().toString(), etLongitude.getText().toString());
                    Context context = getApplicationContext();
                    CharSequence text = etName.getText().toString() + " adicionado!";

                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    toast.show();
                } catch(Exception e) {
                    Log.d("ERROR", e.toString());
                }
            }
        });
    }

    private void findViews() {
        this.sp1 = (Spinner) findViewById(R.id.sp1);
        this.etName = (EditText) findViewById(R.id.etName);
        this.etDescription = (EditText) findViewById(R.id.etDescription);
        this.etOpenHour = (EditText) findViewById(R.id.etOpenHour);
        this.etCloseHour = (EditText) findViewById(R.id.etCloseHour);
        this.etContact = (EditText) findViewById(R.id.etContact);
        this.etImgUrl = (EditText) findViewById(R.id.etImgUrl);
        this.etLatitude = (EditText) findViewById(R.id.etLatitude);
        this.etLongitude = (EditText) findViewById(R.id.etLongitude);
        this.btnAdd = (Button) findViewById(R.id.btnUpdate);
    }
}
