package io.github.spoonless.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;


public class InternetActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);
        textView = findViewById(R.id.infoView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        DownloadTextTask downloadTextTask = new DownloadTextTask() {
            @Override
            protected void onPostExecute(String data) {
                textView.setText(data);
            }
        };

        textView.setText("Chargement en cours...");
        try {
            URL url = new URL("https://tools.ietf.org/rfc/rfc7230.txt");
            downloadTextTask.execute(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
