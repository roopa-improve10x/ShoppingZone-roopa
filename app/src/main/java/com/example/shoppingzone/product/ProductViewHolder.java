package com.example.shoppingzone.product;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingzone.databinding.ProductItemBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    ProductItemBinding binding;
    public ProductViewHolder(ProductItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
