package com.example.shoppingzone.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.shoppingzone.OnItemActionListener;
import com.example.shoppingzone.network.FakeApi;
import com.example.shoppingzone.network.FakeApiService;
import com.example.shoppingzone.product.ProductActivity;
import com.example.shoppingzone.databinding.ActivityCategoriesActiviyBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoriesActivity extends AppCompatActivity {

    private ArrayList<String> categories = new ArrayList<>();
    private CategoryAdapter categoryAdapter;
    private ActivityCategoriesActiviyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesActiviyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        getSupportActionBar().setTitle("Categories");
        setCategoryAdapter();
        setUpCategoryRv();
        getData();
    }
    private void setCategoryAdapter() {
        categoryAdapter = new CategoryAdapter();
        categoryAdapter.setData(categories);
        categoryAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClick(String categoryName) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                intent.putExtra("category", categoryName);
                startActivity(intent);
            }
        });
    }

    private void setUpCategoryRv() {
        binding.categoriesRv.setAdapter(categoryAdapter);
        binding.categoriesRv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void getData() {
        FakeApi api = new FakeApi();
        FakeApiService service = api.createFakeApiService();
        Call<List<String>> call = service.fetchCategories();
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                List<String> strings = response.body();
                categoryAdapter.setData((ArrayList<String>) strings);
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });
    }

}