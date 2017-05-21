package com.example.toshba.exampletwo;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by TOSHİBA on 18.05.2017.
 */

public class Myadapter2 extends RecyclerView.Adapter<Myadapter2.ViewHolder> {
    List<photos_model> photoslist;
    private ItemListener listener;

    public Myadapter2(List<photos_model> list2) {
        this.photoslist = list2;
    }

    void setOItemLictener(ItemListener itemlistener) {
        this.listener = itemlistener;
    }

    @Override
    public Myadapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.photos_main, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final Myadapter2.ViewHolder holder, int position) {
        Picasso.with(holder.itemView.getContext()).load(Uri.parse(photoslist.get(position).getThumbnailUrl())).into(holder.image1);
        holder.text.setText(photoslist.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onitemclicked(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return photoslist.size();
    }

    public interface ItemListener {
        void onitemclicked(int i);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image1;
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            image1 = (ImageView) itemView.findViewById(R.id.imageView1);
            text = (TextView) itemView.findViewById(R.id.textView1);
        }
    }
}
