package com.example.toshba.exampletwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by TOSHİBA on 17.05.2017.
 */

public class Photos extends Activity {
    RecyclerView recyclerView2;
    List<photos_model> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerview2);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView2.setLayoutManager(linearLayoutManager);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView2.setLayoutManager(layoutManager);

        int pht = (getIntent().getExtras().getInt("photos"));
       ApiClient.createservice().photos(pht).enqueue(new Callback<List<photos_model>>() {
           @Override
           public void onResponse(Call<List<photos_model>> call, Response<List<photos_model>> response) {
               list2=response.body();
               Myadapter2 adapter=new Myadapter2(list2);
               adapter.setOItemLictener(new Myadapter2.ItemListener() {
                   @Override
                   public void onitemclicked(int i) {

                       Intent intent=new Intent(Photos.this,Photos_s.class);
                       intent.putExtra("photoss",list2.get(i).getUrl());
                       startActivity(intent);
                   }
               });
               recyclerView2.setAdapter(adapter);

           }

           @Override
           public void onFailure(Call<List<photos_model>> call, Throwable t) {

           }
       });
    }
}
