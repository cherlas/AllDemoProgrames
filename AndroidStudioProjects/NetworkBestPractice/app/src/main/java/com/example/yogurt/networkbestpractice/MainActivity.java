package com.example.yogurt.networkbestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button sendRequest;
    private EditText answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendRequest= (Button) findViewById(R.id.send_request);
        answer= (EditText) findViewById(R.id.editText);
        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtil.sendRequest("http://www.baidu.com", new HttpCallbackListener() {
                    @Override
                    public void onFinish(String response) {
                        Log.d("MainActivity","Lucky Dog");
                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            });
    }
}
