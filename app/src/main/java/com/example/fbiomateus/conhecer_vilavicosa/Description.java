package com.example.fbiomateus.conhecer_vilavicosa;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.SphericalUtil;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;

//

public class Description extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private Button btnDirection;
    private TextView txtDescription, txtHours, txtContact, txtDistance;
    private Intent intent;
    private String latitude;
    private String longitude;

    private GoogleApiClient mGoogleApiClient;
    public Location mLastLocation;
    private final int MY_PERMISSION_REQUEST_ID = 1234;
    private final int MY_PERMISSION_REQUEST_ID_0 = 1234;
    private double dist, lat, lng;
    private LatLng pointLatLng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra("name"));
        findViews();

        final ImageView imgPlace = (ImageView) findViewById(R.id.imgPlace);
        Picasso.with(getApplicationContext()).load(intent.getStringExtra("imgUrl")).into(imgPlace);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        btnDirection.setText(intent.getStringExtra("name"));
        txtDescription.setText(intent.getStringExtra("description"));
        txtHours.setText(intent.getStringExtra("openHour") + " - " + intent.getStringExtra("closeHour"));
        txtContact.setText(intent.getStringExtra("contact"));
        lat = Double.valueOf(intent.getStringExtra("latitude"));
        lng = Double.valueOf(intent.getStringExtra("longitude"));

        pointLatLng = new LatLng(lat,lng);

        this.btnDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:" + lat + "," + lng + "?q=" + lat + "," + lng + " (" + btnDirection.getText() + ")"));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onConnected(Bundle bundle) {
        getLocation();
        compareLocation();

    }

    private void findViews() {
        this.btnDirection = (Button) findViewById(R.id.btnDirection);
        this.txtDescription = (TextView) findViewById(R.id.txtDescription);
        this.txtHours = (TextView) findViewById(R.id.txtHours);
        this.txtContact = (TextView) findViewById(R.id.txtContact);
        this.txtDistance = (TextView) findViewById(R.id.txtDistance);
    }

    protected void getLocation(){
        //check permission to acess location
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        //if not allowed, get it
        if (permissionCheck == PackageManager.PERMISSION_DENIED){
            //ask for permission
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION},MY_PERMISSION_REQUEST_ID);
            return;
        }

        //check permission to acess location
        int permissionCheck1 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        //if not allowed, get it
        if (permissionCheck1 == PackageManager.PERMISSION_DENIED){
            //ask for permission
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_COARSE_LOCATION},MY_PERMISSION_REQUEST_ID_0);
            return;
        }

        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mGoogleApiClient);
        if (mLastLocation != null) {
            Log.d("ADASDASDSAD", "WORKING");
        }
        else{
            Log.d("Conhecer VV","Localizaçao not working");
        }

    }

    protected void compareLocation(){
        if (mLastLocation == null){
            Log.d("Conhecer Vila Viçosa", "currentLocation == null");
        }else{
            LatLng myLatLng = new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());
            dist = SphericalUtil.computeDistanceBetween(myLatLng,pointLatLng);
            dist = dist/1000;
            DecimalFormat df = new DecimalFormat("0.##");
            txtDistance.setText(String.valueOf(df.format(dist)) + " km");
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    @Override
    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(this.getClass().getSimpleName(), "onPause()");

        if(mGoogleApiClient.isConnected()){
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            mGoogleApiClient.disconnect();
        }
    }



    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();
    }
}
