package com.example.simplenotificationv2;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

/*
this wraps the whole application with its components like activities and services
if we want to set up at the start of the application and not in a particular activity, this is the place to do it
*/
public class AppClass extends Application {

    public static final String CHANNEL_1_ID = "channel1";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannels();
    }

    private void createNotificationChannels() {
        //check if we are on the project android version or higher
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1"/*visible to the user*/,
                    NotificationManager.IMPORTANCE_HIGH);
            //customization
            channel1.setDescription("This is Channel 1");

            //create channel
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);

            //TODO 2: go to manifest and register this class +
            // go to activity_main.xml and add a button to call the notification +
            // return to MainActivity
        }
    }
}
