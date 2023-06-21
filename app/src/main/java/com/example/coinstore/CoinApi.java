package com.example.coinstore;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinApi {
    public CoinServiceApi  createCoinApiService() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.COINS_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
         CoinServiceApi coinServiceApi = retrofit.create(CoinServiceApi.class);
        return coinServiceApi;
    }
}
