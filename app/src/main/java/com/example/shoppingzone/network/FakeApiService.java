package com.example.shoppingzone.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FakeApiService {

    @GET("/products/categories")
    Call<List<String>> fetchCategories();
}
