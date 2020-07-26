package io.github.spoonless.demoactivite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Uri intentData = getIntent().getData();
        String message = String.format("Vous avez ouvert l'activité à partir de l'adresse %s", intentData.toString());

        TextView textView = findViewById(R.id.messageIntent);
        textView.setText(message);
    }

    public void call(View view) {
        Uri numero = Uri.parse("tel:0601020304");
        Intent intentAppel = new Intent(Intent.ACTION_DIAL, numero);

        List<ResolveInfo> infos = getPackageManager().queryIntentActivities(intentAppel, PackageManager.MATCH_DEFAULT_ONLY);
        if (! infos.isEmpty()) {
            startActivity(intentAppel);
        } else {
            Toast.makeText(this, "Impossible d'appeler",  Toast.LENGTH_LONG).show();
        }
    }
}