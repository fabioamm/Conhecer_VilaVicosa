package com.example.fbiomateus.conhecer_vilavicosa;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class Description extends AppCompatActivity {

    private Button btnDirection;
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

        final Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("name"));
        txtName.setText(intent.getStringExtra("name"));
        txtDescription.setText(intent.getStringExtra("description"));
        txtHours.setText(intent.getStringExtra("openHour") + " - " + intent.getStringExtra("closeHour"));
        txtContact.setText(intent.getStringExtra("contact"));

        new DownLoadImageTask(imgPlace).execute(intent.getStringExtra("imgUrl"));

        this.btnDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destinationLatitude = intent.getStringExtra("latitude");
                String destinationLongitude = intent.getStringExtra("longitude");

                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:"+destinationLatitude+","+destinationLongitude));
                i.setClassName("com.google.android.apps.maps",
                        "com.google.android.maps.MapsActivity");
                startActivity(i);
            }
        });
    }

    private void findViews() {
        this.btnDirection = (Button) findViewById(R.id.btnDirection);
        this.txtName = (TextView) findViewById(R.id.txtName);
        this.txtDescription = (TextView) findViewById(R.id.txtDescription);
        this.txtHours = (TextView) findViewById(R.id.txtHours);
        this.txtContact = (TextView) findViewById(R.id.txtContact);
        this.imgPlace = (ImageView) findViewById(R.id.imgPlace);
    }

    private class DownLoadImageTask extends AsyncTask<String,Void,Bitmap> {
        ImageView imageView;

        public DownLoadImageTask(ImageView imageView){
            this.imageView = imageView;
        }

        /*
            doInBackground(Params... params)
                Override this method to perform a computation on a background thread.
         */
        protected Bitmap doInBackground(String...urls){
            String urlOfImage = urls[0];
            Bitmap logo = null;
            try{
                InputStream is = new URL(urlOfImage).openStream();
                /*
                    decodeStream(InputStream is)
                        Decode an input stream into a bitmap.
                 */
                logo = BitmapFactory.decodeStream(is);
            }catch(Exception e){ // Catch the download exception
                e.printStackTrace();
            }
            return logo;
        }

        /*
            onPostExecute(Result result)
                Runs on the UI thread after doInBackground(Params...).
         */
        protected void onPostExecute(Bitmap result){
            imageView.setImageBitmap(result);
        }
    }
}
