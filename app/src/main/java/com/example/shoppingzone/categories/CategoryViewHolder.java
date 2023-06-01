package com.example.shoppingzone.categories;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingzone.databinding.CategoryItemBinding;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    CategoryItemBinding binding;

    public CategoryViewHolder(CategoryItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
