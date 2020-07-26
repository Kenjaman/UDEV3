package io.github.spoonless.demoservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button chooseWordButton;
    private RandomService randomService;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            RandomService.RandomServiceBinder binder = (RandomService.RandomServiceBinder) service;
            randomService = binder.getService();
            chooseWordButton.setEnabled(true);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            chooseWordButton.setEnabled(false);
            randomService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chooseWordButton = findViewById(R.id.chooseWordButton);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, RandomService.class);
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unbindService(serviceConnection);
    }

    public void launchBackgroundService(View view) {
        Intent intent = new Intent(this, MessageBackgroundService.class);
        intent.putExtra("message", "hello world");
        startService(intent);
    }

    public void chooseWord(View view) {
        if(randomService != null) {
            String randomWord = randomService.getRandomWord();
            Toast.makeText(this, randomWord, Toast.LENGTH_SHORT).show();
        }
    }
}
