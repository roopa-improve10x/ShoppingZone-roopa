package com.example.shoppingzone.categories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.shoppingzone.Category;
import com.example.shoppingzone.CategoryAdapter;
import com.example.shoppingzone.OnItemActionListener;
import com.example.shoppingzone.ProductActivity;
import com.example.shoppingzone.R;
import com.example.shoppingzone.databinding.ActivityCategoriesActiviyBinding;

import java.util.ArrayList;

public class CategoriesActiviy extends AppCompatActivity {

    private ArrayList<String> categories = new ArrayList<>();
    private CategoryAdapter categoryAdapter;
    private ActivityCategoriesActiviyBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoriesActiviyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setCategoryAdapter();
        setUpCategoryRv();
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
}