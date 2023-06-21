package com.example.coinstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.coinstore.databinding.ActivityCoinsBinding;
import com.example.coinstore.model.Coin;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CoinsActivity extends AppCompatActivity {
    private ActivityCoinsBinding activityCoinsBinding;
    private CoinsAdapter adapter;
    private List<Coin> coins = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCoinsBinding = ActivityCoinsBinding.inflate(getLayoutInflater());
        setContentView(activityCoinsBinding.getRoot());
        setupAdapter();
        connectAdapter();
        fetchCoins();
    }

    private void fetchCoins() {
        CoinServiceApi coinServiceApi = new CoinApi().createCoinApiService();
        Call<List<Coin>> call = coinServiceApi.fetchCoin();
        call.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> response) {
            List<Coin> coinList = response.body();
            adapter.setCoins(coinList);
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable t) {

            }
        });
    }

    private void setupAdapter() {
        adapter = new CoinsAdapter();
        adapter.setCoins(coins);
        adapter.setActive(true);
    }

    private void connectAdapter() {
        activityCoinsBinding.coinRv.setLayoutManager(new LinearLayoutManager(this));
        activityCoinsBinding.coinRv.setAdapter(adapter);
    }
}