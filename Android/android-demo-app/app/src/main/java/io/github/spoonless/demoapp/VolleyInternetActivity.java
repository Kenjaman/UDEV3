package io.github.spoonless.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyInternetActivity extends AppCompatActivity {

    private static final Object REQUEST_TAG = new Object();
    private RequestQueue requestQueue;
    private TextView infoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_internet);
        infoView = findViewById(R.id.infoView);
        requestQueue = Volley.newRequestQueue(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String url = "https://tools.ietf.org/rfc/rfc7230.txt";
        StringRequest request = new StringRequest(Request.Method.GET, url,
           new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                infoView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                infoView.setText("Erreur de téléchargement : " + error.getMessage());
            }
        });
        infoView.setText("Chargement en cours...");
        request.setTag(REQUEST_TAG);
        requestQueue.add(request);
    }

    @Override
    protected void onPause() {
        super.onPause();
        requestQueue.cancelAll(REQUEST_TAG);
    }
}
