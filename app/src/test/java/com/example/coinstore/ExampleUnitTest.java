package com.example.coinstore;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.coinstore.model.Coin;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getCoin() throws IOException {
        CoinServiceApi coinServiceApi = new CoinApi().createCoinApiService();
        Call<List<Coin>> call = coinServiceApi.fetchCoin();
        List<Coin> coins = call.execute().body();
        assertNotNull(coins);
        assertFalse(coins.isEmpty());
        System.out.println(new Gson().toJson(coins));
    }
}