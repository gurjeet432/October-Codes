package com.example.daredevil.notification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends Application {
   public static final String CHANNEL_1_ID="channel1";
    public static final String CHANNEL_2_ID="channel2";


    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannels();

    }
    private void createNotificationChannels(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            //channel one .......
            NotificationChannel notificationChannel1=new NotificationChannel(
                    CHANNEL_1_ID,
                    "channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            notificationChannel1.setDescription("THIS IS CHANNEL 1");
            // channel two ......
            NotificationChannel notificationChannel2=new NotificationChannel(
                    CHANNEL_2_ID,
                    "channel 2",
                    NotificationManager.IMPORTANCE_LOW
            );
            notificationChannel2.setDescription("THIS IS CHANNEL 2");

            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel1);
            manager.createNotificationChannel(notificationChannel2);

        }


    }
}
