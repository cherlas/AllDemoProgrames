package com.example.yogurt.learnrv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Yogurt on 3/22/16.
 */
class MyAdapter extends RecyclerView.Adapter {

    class ViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView tvTitle,tvContent;
        public ViewHolder(View root) {
            super(root);

            tvContent= (TextView) root.findViewById(R.id.content);
            tvTitle= (TextView) root.findViewById(R.id.title);
        }

        public TextView getTvContent() {
            return tvContent;
        }

        public TextView getTvTitle() {
            return tvTitle;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;
        vh.getTvTitle().setText(data[position].title);
        vh.getTvContent().setText(data[position].content);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    private listData[] data=new listData[]{new listData("AA","AAAAA"),new listData("BB","BBBBB")};
}
