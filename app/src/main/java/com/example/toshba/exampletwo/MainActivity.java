package com.example.toshba.exampletwo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView1;
    List<albums_model> list1;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView1 = (RecyclerView) findViewById(R.id.recyclerview1);
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Yükleniyor..");
        progressDialog.show();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView1.setLayoutManager(linearLayoutManager);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),1);
        recyclerView1.setLayoutManager(layoutManager);

        ApiClient.createservice().albums().enqueue(new Callback<List<albums_model>>() {
            @Override
            public void onResponse(Call<List<albums_model>> call, Response<List<albums_model>> response) {

                progressDialog.hide();
                list1 = response.body();
                MyAdapter adapter = new MyAdapter(list1);
                recyclerView1.setAdapter(adapter);
                adapter.setonitemlistener(new MyAdapter.ItemListener() {
                    @Override
                    public void onItemClicked(int index) {
                        Intent intent=new Intent(MainActivity.this,Photos.class);
                        intent.putExtra("photos",list1.get(index).getId());
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onFailure(Call<List<albums_model>> call, Throwable t) {

            }
        });

    }

}
