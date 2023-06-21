package com.example.coinstore;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coinstore.databinding.CoinsItemBinding;

public class CoinsViewHolder extends RecyclerView.ViewHolder {
        CoinsItemBinding coinsItemBinding;
    public CoinsViewHolder(CoinsItemBinding coinsItemBinding) {
        super(coinsItemBinding.getRoot());
        this.coinsItemBinding = coinsItemBinding;
    }
}
