package io.github.spoonless.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAirplaneActivity(View view) {
        startActivity(new Intent(this, AirplaneActivity.class));
    }

    public void goIntenetActivity(View view) {
        startActivity(new Intent(this, InternetActivity.class));
    }

    public void goVolleyIntenetActivity(View view) {
        startActivity(new Intent(this, VolleyInternetActivity.class));
    }

    public void goRegionActivity(View view) {
        startActivity(new Intent(this, RegionActivity.class));
    }
}
