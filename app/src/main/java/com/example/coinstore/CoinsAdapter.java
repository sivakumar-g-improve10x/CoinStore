package com.example.coinstore;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coinstore.databinding.CoinsItemBinding;
import com.example.coinstore.model.Coin;

import java.util.List;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsViewHolder> {
    private Boolean isActive = false;
    private List<Coin> coins;

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CoinsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        CoinsItemBinding coinsItemBinding = CoinsItemBinding.inflate(layoutInflater,parent,false);
        CoinsViewHolder coinsViewHolder = new CoinsViewHolder(coinsItemBinding);
        return coinsViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoinsViewHolder holder, int position) {
        Coin coin = coins.get(position);
        holder.coinsItemBinding.setCoin(coin);
        holder.coinsItemBinding.setIsActive(isActive);

    }

    @Override
    public int getItemCount() {
        return coins.size();
    }
}
