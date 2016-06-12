package com.example.yogurt.fragmentbestpractice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by Yogurt on 4/20/16.
 */
public class NewsContentActivity extends Activity {
    public static void actionStart(Context context,String newsTitle,String newsContent){
        Intent intent=new Intent(context,NewsContentActivity.class);
        intent.putExtra("newsTitle",newsTitle);
        intent.putExtra("newsContent",newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_content);
        String newsTitle=getIntent().getStringExtra("newsTitle");
        String newsContent=getIntent().getStringExtra("newsContent");
        NewsContentFragment fragment=(NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_frag);
        fragment.refrensh(newsTitle,newsContent);//刷新界面
    }
}
