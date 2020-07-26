package io.github.spoonless.demoactivite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView message;
    private int nbClics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message = findViewById(R.id.textMessage);
        if (savedInstanceState != null) {
            nbClics = savedInstanceState.getInt("nbClics");
        }
        updateMessage();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("nbClics", nbClics);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onBoutonClic(View v) {
        nbClics++;
        updateMessage();
    }

    private void updateMessage() {
        message.setText(String.format("Vous avez cliqué %d fois", nbClics));
    }

}