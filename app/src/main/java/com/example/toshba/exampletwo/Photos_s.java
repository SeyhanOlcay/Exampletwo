package com.example.toshba.exampletwo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by TOSHİBA on 18.05.2017.
 */

public class Photos_s extends Activity {
    ImageView ımageView;
    List<photos_model> list3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photoss_main);
        ımageView=(ImageView)findViewById(R.id.image2);
        String pht = getIntent().getExtras().getString("photoss");
        Picasso.with(getApplicationContext()).load(Uri.parse(pht)).into(ımageView);
    }
}
