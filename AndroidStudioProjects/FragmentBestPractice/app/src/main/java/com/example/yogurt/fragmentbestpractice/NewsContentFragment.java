package com.example.yogurt.fragmentbestpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Yogurt on 4/20/16.
 */
public class NewsContentFragment extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.news_content_frag,container,false);
        return view;
    }

    public void refrensh(String newsTitle,String newsContent){
        View visibilityLayout=view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        TextView newsTitleText=(TextView)view.findViewById(R.id.news_title);
        newsTitleText.setText(newsTitle);

        TextView newsTitleContent=(TextView)view.findViewById(R.id.news_content);
        newsTitleContent.setText(newsContent);
    }
}
