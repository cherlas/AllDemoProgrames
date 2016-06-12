package com.example.yogurt.fragmentbestpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Yogurt on 4/20/16.
 */
public class NewsAdapter extends ArrayAdapter<News>{
    private  int resourceId;
    public NewsAdapter(Context context, int resource, int textViewResourceId, List<News> objects) {
        super(context, resource, textViewResourceId, objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        News news=getItem(position);
        View view;
        if (convertView!=null){
            view=convertView;
        }else {
            view= LayoutInflater.from(getContext()).inflate(resourceId,null);
        }

        TextView newsTitleText=(TextView)view.findViewById(R.id.news_title);
        newsTitleText.setText(news.getTitle());
        return  view;
    }
}
