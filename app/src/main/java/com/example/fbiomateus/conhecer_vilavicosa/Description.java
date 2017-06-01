package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Description extends AppCompatActivity {

    private TextView txtName;
    private TextView txtDescription;
    private TextView txtHours;
    private TextView txtContact;
    private ImageView imgPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_description);
        findViews();

        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("name"));
        txtName.setText(intent.getStringExtra("name"));
        txtDescription.setText(intent.getStringExtra("description"));
        txtHours.setText(intent.getStringExtra("openHour") + " - " + intent.getStringExtra("closeHour"));
        txtContact.setText(intent.getStringExtra("contact"));
    }

    private void findViews() {
        this.txtName = (TextView) findViewById(R.id.txtName);
        this.txtDescription = (TextView) findViewById(R.id.txtDescription);
        this.txtHours = (TextView) findViewById(R.id.txtHours);
        this.txtContact = (TextView) findViewById(R.id.txtContact);
        this.imgPlace = (ImageView) findViewById(R.id.imgPlace);
    }
}
