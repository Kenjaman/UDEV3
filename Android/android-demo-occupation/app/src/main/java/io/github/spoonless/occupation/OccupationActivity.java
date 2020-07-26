package io.github.spoonless.occupation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OccupationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_occupation);

        onNewIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        int occupationId = intent.getIntExtra("occupationId", 0);

        Occupation occupation = OccupationsSingleton.getInstance().getOccupation(occupationId);

        TextView nomView = findViewById(R.id.nomOccupation);
        nomView.setText(occupation.getNom());

        TextView descriptionView = findViewById(R.id.descriptionOccupation);
        descriptionView.setText(occupation.getDescription());

        RecyclerView occupationsView = findViewById(R.id.memeCategorieRecyclerView);
        occupationsView.setLayoutManager(new LinearLayoutManager(this));
        occupationsView.setAdapter(new OccupationAdapter(OccupationsSingleton.getInstance().getOccupationsMemeCategorie(occupation)));
    }
}
