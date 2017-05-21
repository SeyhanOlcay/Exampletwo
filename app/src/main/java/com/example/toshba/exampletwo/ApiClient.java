package com.example.toshba.exampletwo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TOSHİBA on 17.05.2017.
 */

public class ApiClient {
    private static OkHttpClient.Builder okhttpclient=new OkHttpClient.Builder();
    private static Gson gson = new GsonBuilder().create();
    private static GsonConverterFactory gsonConverterFactory=GsonConverterFactory.create(gson);
    private static Retrofit.Builder retrofitbuild=new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(gsonConverterFactory);

    public static   ApiService createservice() {
        OkHttpClient client=okhttpclient.build();
        Retrofit retrofit=retrofitbuild.client(client).build();
        return  retrofit.create(ApiService.class);


    }
}
