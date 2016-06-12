package com.example.yogurt.networkbestpractice;

/**
 * Created by Yogurt on 5/2/16.
 */
public interface HttpCallbackListener {

    void onFinish(String response);
    void onError(Exception e);
}
