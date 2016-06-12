package com.example.yogurt.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent=new Intent(this,MainActivity.class);
        Button button= (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification=new Notification(R.drawable.ic_launcher,"This is Ticker Text", System.currentTimeMillis());
                //notification.setLatestEventInfo
                //该语句的作用是定义了一个不是当即显示的activity，只有当用户拉下notify显示列表，并且单击对应的项的时候，才会触发系统跳转到该activity.
//                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity.this,0,intent,0);
//                Notification builder=new Notification.Builder(MainActivity.this)
//                        .setAutoCancel(true)
//                        .setContentText("This is Content Text")
//                        .setContentTitle("This is Title")
//                        .setSmallIcon(R.drawable.ic_launcher)
//                        .setContentIntent(pendingIntent)
//                        .setWhen(System.currentTimeMillis())
//                        .build();

                //manager.notify(1,notification);
            }
        });

    }
}
