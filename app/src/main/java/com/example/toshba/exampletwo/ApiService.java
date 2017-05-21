package com.example.toshba.exampletwo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by TOSHİBA on 17.05.2017.
 */

public interface ApiService {
    @GET("albums")
    Call<List<albums_model>> albums();

    @GET("photos")
    Call<List<photos_model>> photos(@Query("albumId") int albumId);

}
