package com.example.shoppingzone.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.shoppingzone.databinding.ActivityProductBinding;
import com.example.shoppingzone.models.Product;
import com.example.shoppingzone.network.FakeApi;
import com.example.shoppingzone.network.FakeApiService;
import com.example.shoppingzone.product_details.ProductDetails;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

     private ActivityProductBinding binding;
     private ArrayList<Product> products = new ArrayList<>();
     private ProductAdapter productAdapter;
     private String categoryName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = ActivityProductBinding.inflate(getLayoutInflater());
       setContentView(binding.getRoot());
       if(getIntent().hasExtra("category")) {
           categoryName = getIntent().getStringExtra("category");
       }
       setProductAdapter();
       setProductsRv();
       fetchData();
    }

    public void fetchData() {
        FakeApi api = new FakeApi();
        FakeApiService service = api.createFakeApiService();
        Call<List<Product>> call = service.fetchProducts(categoryName);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> products = response.body();
                productAdapter.setData(products);
            }
            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });




    }

    public void setProductsRv() {
        binding.productRv.setAdapter(productAdapter);
        binding.productRv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void setProductAdapter() {
        productAdapter = new ProductAdapter();
        productAdapter.setData(products);
        productAdapter.setOnItemActionListener(new OnItemActionListener() {
            @Override
            public void onClick(String product) {
                Intent intent = new Intent(getApplicationContext(), ProductDetails.class);
                intent.hasExtra("category");
                startActivity(intent);
            }
        });

    }
}