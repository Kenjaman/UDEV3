package io.github.spoonless.demoservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Arrays;
import java.util.Random;

public class RandomService extends Service {

    public class RandomServiceBinder extends Binder {

        RandomService getService() {
            return RandomService.this;
        }

    }

    private RandomServiceBinder binder = new RandomServiceBinder();

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    public String getRandomWord() {
        String[] array = {"bonjour", "méchant", "loup", "maison", "pain d'épice"};
        return array[new Random().nextInt(array.length)];
    }

}
