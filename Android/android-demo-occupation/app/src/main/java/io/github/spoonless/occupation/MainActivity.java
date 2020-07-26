package io.github.spoonless.occupation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView occupationsView = findViewById(R.id.occupationsView);
        occupationsView.setLayoutManager(new LinearLayoutManager(this));
        occupationsView.setAdapter(new OccupationAdapter(OccupationsSingleton.getInstance().getOccupations()));
    }

}
