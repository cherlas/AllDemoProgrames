package com.example.yogurt.smstest;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView sender,content;
    private IntentFilter receiveFilter,sendFilter;
    private MessageReceiver messageReceiver;
    private Button send;
    private TextView to;
    private EditText msgInput;
    private SendStatusReceiver sendStatusReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sender= (TextView) findViewById(R.id.sender);
        content= (TextView) findViewById(R.id.content);

        receiveFilter=new IntentFilter();
        receiveFilter.addAction("android.provider.Telephony.SMS_RECEIVED");
        receiveFilter.setPriority(1000);
        messageReceiver=new MessageReceiver();
        registerReceiver(messageReceiver,receiveFilter);

        sendFilter=new IntentFilter();
        sendFilter.addAction("SENT_SMS_ACTION");
        sendStatusReceiver =new SendStatusReceiver();
        registerReceiver(sendStatusReceiver,sendFilter);

        to= (TextView) findViewById(R.id.to);
        send= (Button) findViewById(R.id.send);
        msgInput= (EditText) findViewById(R.id.msg_input);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager smsManager=SmsManager.getDefault();
                Intent sendIntent=new Intent("SEND_SMS_ACTION");
                PendingIntent pi=PendingIntent.getBroadcast(MainActivity.this,0,sendIntent,0);
                smsManager.sendTextMessage(to.getText().toString(),null,msgInput.getText().toString(),pi,null);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(messageReceiver);
        unregisterReceiver(sendStatusReceiver);
    }

    class MessageReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            abortBroadcast();
            Bundle bundle=intent.getExtras();
            Object[] pdus= (Object[]) bundle.get("pdus");
            SmsMessage[] messages=new SmsMessage[pdus.length];
            for(int i=0;i<pdus.length;i++){
                messages[i]= SmsMessage.createFromPdu((byte[]) pdus[i]);
            }

            String address=messages[0].getOriginatingAddress();//发送号码
            String fullMessage="";
            for (SmsMessage message:messages){
                fullMessage+=message.getMessageBody();//短信内容
            }

            sender.setText(address);
            content.setText(fullMessage);

        }
    }


    class SendStatusReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (getResultCode()==RESULT_OK){
                Toast.makeText(context,"Send Succeeded",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context,"Send failed",Toast.LENGTH_SHORT).show();
            }
        }
    }

}
