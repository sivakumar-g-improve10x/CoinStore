package com.example.coinstore;

import com.example.coinstore.model.Coin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoinServiceApi {
       @GET(Constants.COIN_END_POINT)
        Call<List<Coin>> fetchCoin();
}
