package com.example.toshba.exampletwo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by TOSHİBA on 17.05.2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<albums_model> albumslist;

    private  ItemListener listener;

    public MyAdapter(List<albums_model> list1) {
        this.albumslist = list1;
    }

    public interface ItemListener {
         void onItemClicked (int index);
    }

    void setonitemlistener(ItemListener itemListener){
        this.listener=itemListener;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.albums_main, parent, false);
        return  new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder holder, int position) {
        holder.textView1.setText(albumslist.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onItemClicked(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumslist.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder  {

        TextView textView1;

         ViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.textView);



        }

    }
}
