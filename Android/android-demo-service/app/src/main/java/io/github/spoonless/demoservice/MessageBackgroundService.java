package io.github.spoonless.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageBackgroundService extends Service {

    public static final String TAG = "MsgBackgroundService";
    private ExecutorService executorService;

    /*
     * La redéfinition de cette méthode est obligatoire car elle est déclarée
     * abstraite dans la classe Service. Néanmoins, cette méthode n'est utilisée
     * que pour les services liés (Bound Service).
     */
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Lancement du service", Toast.LENGTH_SHORT).show();
        // Création d'un service d'exécution avec cinq threads.
        this.executorService = Executors.newFixedThreadPool(5);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Appel à onStartCommand");
        String message = intent.getStringExtra("message");
        // Création de l'exécuteur et ajout dans la fil d'attente du service.
        // L'exécuteur sera lancé dans un thread à part dès que possible.
        this.executorService.execute(new LogMessageExecutor(message, startId));
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Arrêt du service");
        Toast.makeText(this, "Arrêt du service", Toast.LENGTH_SHORT).show();
        // arrêt du service d'exécution
        executorService.shutdown();
    }

    /**
     * Classe interne fournissant le traitement à réaliser
     * en tâche de fond
     */
    private class LogMessageExecutor implements Runnable {

        private String message;
        private int startId;

        LogMessageExecutor(String message, int startId) {
            this.message = message;
            this.startId = startId;
        }

        @Override
        public void run() {
            try {
                Log.i(TAG, "Je suis un service de log avec comme message : " + this.message);
                // On attend 3 secondes pour simuler un traitement
                Thread.sleep(3000);
                Log.i(TAG, "Fin de l'exécution");
            } catch (InterruptedException e) {
                // Si le thread est interrompu par un signal (rien de spécial à faire)
            } finally {
                stopSelf(this.startId);
            }
        }
    }
}
