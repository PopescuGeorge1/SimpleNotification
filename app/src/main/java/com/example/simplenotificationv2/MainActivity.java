package com.example.simplenotificationv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.simplenotificationv2.AppClass.CHANNEL_1_ID;
/*
TODO 1: Create ApplicationClass extends Application
.....
TODO 3: Create and initialize the NotificationManagerCompat and Button

TODO : This notification can be swiped away
*/

public class MainActivity extends AppCompatActivity {

    private NotificationManagerCompat notificationManager;
    private Button notifBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = NotificationManagerCompat.from(this);
        notifBtn = findViewById(R.id.notifBtn1);
        //TODO 4: add method to Button for calling the Notification
        notifBtn.setOnClickListener(this::sendToChannel1);
    }

    public void sendToChannel1(View v){
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle("Notification 1")
                .setContentText("This is notification 1")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)//
                .build();
        notificationManager.notify(1,notification);

    }

}