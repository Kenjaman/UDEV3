package io.github.spoonless.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

public class AirplaneActivity extends AppCompatActivity {

    private TextView airplaneModeView;
    private AirplaneModeReceiver airplaneModeReceiver = new AirplaneModeReceiver();

    private class AirplaneModeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            setAirplaneModeMessage();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplication().getApplicationContext();
        setContentView(R.layout.activity_airplane);
        airplaneModeView = findViewById(R.id.airplaneMode);
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeReceiver, intentFilter);
        setAirplaneModeMessage();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(airplaneModeReceiver);
    }

    private void setAirplaneModeMessage() {
        if(airplaneModeView != null) {
            airplaneModeView.setText(isAirplaneMode() ? "Mode avion": "Pas mode avion");
        }
    }

    private boolean isAirplaneMode() {
        return Settings.System.getInt(this.getContentResolver(),
                                      Settings.System.AIRPLANE_MODE_ON,
                                      0) != 0;
    }
}
