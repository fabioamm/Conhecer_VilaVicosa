package com.example.fbiomateus.conhecer_vilavicosa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddPlace extends AppCompatActivity {
    private DatabaseAccess databaseAccess;
    private Place place;
    private EditText etType;
    private EditText etName;
    private EditText etDescription;
    private EditText etOpenHour;
    private EditText etCloseHour;
    private EditText etContact;
    private EditText etImgUrl;
    private Button btnAdd;
    private Spinner sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);
        findViews();
        getSupportActionBar().setTitle("Adicionar local");

        this.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (place == null)
                    insertPlace();
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
        this.btnAdd = (Button) findViewById(R.id.btnAdd);
    }

    private void insertPlace() {
        databaseAccess.open();
        Place newPlace = new Place();
        newPlace.setId("100");
        newPlace.setType(sp1.getSelectedItem().toString());
        newPlace.setName(etName.getText().toString());
        newPlace.setDescription(etDescription.getText().toString());
        newPlace.setOpenHour(etOpenHour.getText().toString());
        newPlace.setCloseHour(etCloseHour.getText().toString());
        newPlace.setContact(etContact.getText().toString());
        newPlace.setImgUrl(etImgUrl.getText().toString());

        databaseAccess.insertPlace(newPlace);
        databaseAccess.close();
        this.finish();
    }
}
