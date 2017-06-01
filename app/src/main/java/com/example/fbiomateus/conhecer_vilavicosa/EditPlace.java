package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EditPlace extends AppCompatActivity {

    DBHelper dbHelper;
    private Spinner sp1;
    private int id;
    private EditText etName;
    private EditText etDescription;
    private EditText etOpenHour;
    private EditText etCloseHour;
    private EditText etContact;
    private EditText etImgUrl;
    private EditText etLatitude;
    private EditText etLongitude;
    private Button btnUpdate;
    private Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_place);
        getSupportActionBar().setTitle("Editar/Apagar local");
        findViews();
        dbHelper = new DBHelper(this);

        Intent intent = getIntent();
        id = intent.getExtras().getInt("id");
        etName.setText(intent.getStringExtra("name"));
        etDescription.setText(intent.getStringExtra("description"));
        etOpenHour.setText(intent.getStringExtra("openHour"));
        etCloseHour.setText(intent.getStringExtra("closeHour"));
        etContact.setText(intent.getStringExtra("contact"));
        etImgUrl.setText(intent.getStringExtra("imgUrl"));
        etLatitude.setText(intent.getStringExtra("latitude"));
        etLongitude.setText(intent.getStringExtra("longitude"));

        this.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dbHelper.updatePlace(id, sp1.getSelectedItem().toString(), etName.getText().toString(), etDescription.getText().toString(), etOpenHour.getText().toString(), etCloseHour.getText().toString(), etContact.getText().toString(), etImgUrl.getText().toString(), etLatitude.getText().toString(), etLongitude.getText().toString());
                    Context context = getApplicationContext();
                    CharSequence text = etName.getText().toString() + " atualizado!";

                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent = new Intent(EditPlace.this, ReservedAreaMenu.class);
                    startActivity(intent);
                } catch(Exception e) {
                    Log.d("ERROR", e.toString());
                }
            }
        });

        this.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dbHelper.deletePlace(id);
                    Context context = getApplicationContext();
                    CharSequence text = etName.getText().toString() + " removido!";

                    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                    toast.show();

                    Intent intent = new Intent(EditPlace.this, ReservedAreaMenu.class);
                    startActivity(intent);
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
        this.btnUpdate = (Button) findViewById(R.id.btnUpdate);
        this.btnDelete = (Button) findViewById(R.id.btnDelete);
    }
}
