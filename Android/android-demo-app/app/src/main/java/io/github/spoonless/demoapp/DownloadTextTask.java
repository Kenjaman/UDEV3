package io.github.spoonless.demoapp;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class DownloadTextTask extends AsyncTask<URL, Integer, String> {

    private static final String TAG = "DownloadTextTask";

    @Override
    protected String doInBackground(URL... urls) {
        StringBuilder buffer = new StringBuilder();
        for(URL url: urls) {
            try {
                buffer.append(download(url));
            } catch (IOException e) {
                Log.e(TAG, "Erreur lors de l'accès à Internet", e);
            }
        }
        return buffer.toString();
    }

    private String download(URL url) throws IOException {
        Scanner scanner = null;
        try {
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            scanner = new Scanner(stream).useDelimiter("\0");
            return scanner.next();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
